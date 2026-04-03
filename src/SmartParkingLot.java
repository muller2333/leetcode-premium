import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

// 定义枚举类型
enum SpotType {
    // 普通、VIP、残疾人
    REGULAR, VIP, DISABLED
}

enum VehicleType {
    // 小车、大车
    SMALL_VEHICLE, LARGE_VEHICLE
}

enum SpotStatus {
    // 空闲、占用
    FREE, OCCUPIED
}

class ParkingSpot {
    final int id, floor;
    final SpotType type;
    SpotStatus status = SpotStatus.FREE;

    ParkingSpot(int id, int floor, SpotType type) {
        this.id = id;
        this.floor = floor;
        this.type = type;
    }
}

class Vehicle {
    final String plate;
    final VehicleType type;

    Vehicle(String plate, VehicleType type) {
        this.plate = plate;
        this.type = type;
    }
}

class Ticket {
    final String ticketId, plate;
    final VehicleType vehicleType;
    final ParkingSpot assignedSpot;
    LocalDateTime entryTime;
    LocalDateTime exitTime;
    double fee;

    Ticket(String plate, VehicleType type, ParkingSpot spot) {
        this.ticketId = "TICKET-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.plate = plate;
        this.vehicleType = type;
        this.assignedSpot = spot;
        this.entryTime = LocalDateTime.now();
    }
}

// 计费策略
interface PricingStrategy {
    double calculate(VehicleType type, Duration duration);
}

class SizeTieredPricingStrategy implements PricingStrategy {
    private static final long FREE_MINUTES = 30;// 前30分钟免费
    private static final long MINUTES_PER_DAY = 1440;// 每24小时重置
    private static final int SMALL_CAP = 16;

    @Override
    public double calculate(VehicleType type, Duration duration) {
        double base = calcSmallVehicleBase(duration);
        // 大车费用是小车的3倍
        return type == VehicleType.LARGE_VEHICLE ? base * 3.0 : base;
    }

    private double calcSmallVehicleBase(Duration duration) {
        long total = duration.toMinutes();
        if (total <= 0)
            return 0.0;

        long days = total / MINUTES_PER_DAY;
        long remain = total % MINUTES_PER_DAY;

        double fee = days * SMALL_CAP;

        if (remain > FREE_MINUTES) {
            long chargeable = remain - FREE_MINUTES;
            long blocks = (chargeable + 29) / 30; // 向上取整：每30分钟收费1元
            fee += Math.min(blocks, SMALL_CAP); // 单日封顶保护
        }
        return fee;
    }
}

public class SmartParkingLot {
    private final List<ParkingSpot> allSpots = new ArrayList<>();
    private final Map<String, Ticket> activeTickets = new HashMap<>();
    private PricingStrategy pricingStrategy;
    private double totalRevenue = 0.0;
    private final ReentrantLock lock = new ReentrantLock();
    private boolean initialized = false;

    /**
     * 停车场初始化：设置楼层数、每层车位类型与数量
     */
    public void initialize(int floors, Map<Integer, EnumMap<SpotType, Integer>> floorLayouts,
            PricingStrategy strategy) {
        lock.lock();
        try {
            if (initialized)
                throw new IllegalStateException("停车场已初始化，请勿重复调用");
            if (floors <= 0 || strategy == null)
                throw new IllegalArgumentException("参数无效：楼层必须>0且计费策略不可为空");

            allSpots.clear();
            activeTickets.clear();
            totalRevenue = 0.0;
            int spotId = 1;

            for (int f = 1; f <= floors; f++) {
                EnumMap<SpotType, Integer> layout = floorLayouts.get(f);
                if (layout == null || layout.isEmpty()) {
                    throw new IllegalArgumentException("楼层 " + f + " 未配置车位分布");
                }
                for (Map.Entry<SpotType, Integer> entry : layout.entrySet()) {
                    if (entry.getValue() < 0)
                        throw new IllegalArgumentException("车位数量不能为负数");
                    for (int i = 0; i < entry.getValue(); i++) {
                        allSpots.add(new ParkingSpot(spotId++, f, entry.getKey()));
                    }
                }
            }
            this.pricingStrategy = strategy;
            this.initialized = true;
            System.out.printf("初始化完成: %d 层 | 总车位: %d 个%n", floors, allSpots.size());
        } finally {
            lock.unlock();
        }
    }

    /**
     * 车辆入场：自动分配最优车位，生成停车票据
     */
    public Optional<Ticket> enter(Vehicle vehicle) {
        lock.lock();
        try {
            if (!initialized || activeTickets.containsKey(vehicle.plate)) {
                return Optional.empty(); // 未初始化或车辆已在场内
            }
            ParkingSpot spot = findOptimalSpot(vehicle.type);
            if (spot == null)
                return Optional.empty(); // 无合适空位

            spot.status = SpotStatus.OCCUPIED;
            Ticket ticket = new Ticket(vehicle.plate, vehicle.type, spot);
            activeTickets.put(vehicle.plate, ticket);
            return Optional.of(ticket);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 车辆出场：计算费用 + 释放车位 + 累计收入
     */
    public Optional<Ticket> exit(String plate) {
        lock.lock();
        try {
            if (!initialized)
                return Optional.empty();
            Ticket ticket = activeTickets.remove(plate);
            if (ticket == null)
                return Optional.empty(); // 无入场记录

            ticket.exitTime = LocalDateTime.now();
            Duration duration = Duration.between(ticket.entryTime, ticket.exitTime);
            ticket.fee = pricingStrategy.calculate(ticket.vehicleType, duration);
            totalRevenue += ticket.fee;

            ticket.assignedSpot.status = SpotStatus.FREE; // 释放车位
            return Optional.of(ticket);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 实时查询：按类型、楼层查询可用车位
     */
    public List<ParkingSpot> queryAvailable(SpotType type, Integer floor) {
        return allSpots.stream()
                .filter(s -> s.status == SpotStatus.FREE)
                .filter(s -> type == null || s.type == type)
                .filter(s -> floor == null || s.floor == floor)
                .collect(Collectors.toList());
    }

    /**
     * 统计报表：收入统计、车位利用率
     */
    public Map<String, Object> generateReport() {
        long total = allSpots.size();
        long occupied = allSpots.stream().filter(s -> s.status == SpotStatus.OCCUPIED).count();
        double utilization = total > 0 ? (occupied * 100.0 / total) : 0.0;

        return Map.of(
                "totalRevenue", String.format("¥%.2f", totalRevenue),
                "utilizationRate", String.format("%.1f%%", utilization),
                "activeVehicles", activeTickets.size(),
                "availableSpots", total - occupied);
    }

    /**
     * 智能分配算法：合规过滤 > 车型偏好 > 低楼层优先 > 编号优先
     */
    private ParkingSpot findOptimalSpot(VehicleType vType) {
        return allSpots.stream()
                .filter(s -> s.status == SpotStatus.FREE)
                // 大车严禁占用残疾人车位
                .filter(s -> !(s.type == SpotType.DISABLED && vType == VehicleType.LARGE_VEHICLE))
                .min(Comparator.comparingInt((ParkingSpot s) -> {
                    // 大车优先普通/VIP区
                    int typePriority = (vType == VehicleType.LARGE_VEHICLE)
                            ? (s.type == SpotType.REGULAR || s.type == SpotType.VIP ? 0 : 1)
                            : 0;
                    // 大车偏好低层
                    int floorWeight = (vType == VehicleType.LARGE_VEHICLE) ? s.floor : 0;
                    return typePriority * 1000 + floorWeight;
                }).thenComparingInt(s -> s.floor)
                        .thenComparingInt(s -> s.id))
                .orElse(null);
    }

}