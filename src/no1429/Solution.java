package no1429;

import java.util.*;

class FirstUnique {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    List<Integer> list = new ArrayList<>();
    int index = 0;

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }
    }

    public int showFirstUnique() {
        int res = -1;
        while (index < list.size()) {
            if (map.get(list.get(index)) == 1) {
                return list.get(index);
            } else {
                index++;
            }
        }
        return res;
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        list.add(value);
    }

}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */