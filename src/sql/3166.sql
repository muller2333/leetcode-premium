select
    car_id,
    total_fee_paid,
    round(total_fee_paid / duration, 2) avg_hourly_fee,
    lot_id most_time_lot
from
    (
        select
            lot_id,
            car_id,
            sum(duration) over(partition by car_id) duration,
            rank() over(
                partition by car_id
                order by
                    duration desc
            ) rk,
            sum(total) over(partition by car_id) total_fee_paid
        from
            (
                select
                    lot_id,
                    car_id,
                    count(lot_id) cnt,
                    sum(fee_paid) total,
                    sum(duration) duration
                from
                    (
                        select
                            lot_id,
                            car_id,
                            timestampdiff(second, entry_time, exit_time) / 3600 duration,
                            fee_paid
                        from
                            ParkingTransactions
                    ) mid
                group by
                    lot_id,
                    car_id
            ) mid2
    ) mid3
where
    rk = 1
order by
    car_id