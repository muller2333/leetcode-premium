package no1564;

import java.util.TreeMap;

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int box : boxes) {
            map.merge(box, 1, Integer::sum);
        }
        int length = warehouse.length;
        int[] mins = new int[length];
        int min = warehouse[0];
        mins[0] = min;
        for (int i = 1; i < length; i++) {
            mins[i] = min;
            min = Math.min(min, warehouse[i]);
        }
        int res = 0;
        Integer max;
        for (int i = length - 1; i >= 0 && map.size() != 0; i--) {
            max = map.floorKey(mins[i]);
            if (max != null) {
                if (max <= warehouse[i]) {
                    res++;
                    int count = map.get(max);
                    if (count == 1) {
                        map.remove(max);
                    } else {
                        map.put(max, count - 1);
                    }
                } else {
                    max = map.floorKey(warehouse[i]);
                    if (max != null) {
                        res++;
                        int count = map.get(max);
                        if (count == 1) {
                            map.remove(max);
                        } else {
                            map.put(max, count - 1);
                        }
                    }
                }
            }
        }
        return res;
    }
}