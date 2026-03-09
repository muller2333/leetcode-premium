package no3822;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class OrderManagementSystem {
    Map<Integer, Integer> orderMap = new HashMap<>();
    Map<Integer, Set<Integer>> buyMap = new HashMap<>();
    Map<Integer, Set<Integer>> sellMap = new HashMap<>();

    public OrderManagementSystem() {

    }

    public void addOrder(int orderId, String orderType, int price) {
        orderMap.put(orderId, price);
        if (orderType.equals("sell")) {
            sellMap.computeIfAbsent(price, k -> new HashSet<>()).add(orderId);
        } else {
            buyMap.computeIfAbsent(price, k -> new HashSet<>()).add(orderId);
        }
    }

    public void modifyOrder(int orderId, int newPrice) {
        int oldPrice = orderMap.get(orderId);
        if (oldPrice != newPrice) {
            if (buyMap.getOrDefault(oldPrice, new HashSet<>()).contains(orderId)) {
                buyMap.get(oldPrice).remove(orderId);
                buyMap.computeIfAbsent(newPrice, k -> new HashSet<>()).add(orderId);
            } else {
                sellMap.get(oldPrice).remove(orderId);
                sellMap.computeIfAbsent(newPrice, k -> new HashSet<>()).add(orderId);
            }
            orderMap.put(orderId, newPrice);
        }
    }

    public void cancelOrder(int orderId) {
        int price = orderMap.get(orderId);
        buyMap.getOrDefault(price, new HashSet<>()).remove(orderId);
        sellMap.getOrDefault(price, new HashSet<>()).remove(orderId);
    }

    public int[] getOrdersAtPrice(String orderType, int price) {
        Set<Integer> set;
        if (orderType.equals("sell")) {
            set = sellMap.getOrDefault(price, new HashSet<>());
        } else {
            set = buyMap.getOrDefault(price, new HashSet<>());
        }
        int size = set.size();
        int[] res = new int[size];
        int i = 0;
        for (int j : set) {
            res[i++] = j;
        }
        return res;
    }
}

/**
 * Your OrderManagementSystem object will be instantiated and called as such:
 * OrderManagementSystem obj = new OrderManagementSystem();
 * obj.addOrder(orderId,orderType,price);
 * obj.modifyOrder(orderId,newPrice);
 * obj.cancelOrder(orderId);
 * int[] param_4 = obj.getOrdersAtPrice(orderType,price);
 */
