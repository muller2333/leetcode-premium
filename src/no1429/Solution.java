package no1429;

import java.util.*;

//class FirstUnique {
//    Set<Integer> set = new HashSet<>();
//    Set<Integer> resultSet = new LinkedHashSet<>();
//
//    public FirstUnique(int[] nums) {
//        for (int num : nums) {
//            add(num);
//        }
//    }
//
//    public int showFirstUnique() {
//        return resultSet.isEmpty() ? -1 : resultSet.iterator().next();
//    }
//
//    public void add(int value) {
//        if (set.contains(value)) {
//            resultSet.remove(value);
//        } else {
//            resultSet.add(value);
//            set.add(value);
//        }
//    }
//
//}

class FirstUnique {

    private Queue<Integer> queue = new ArrayDeque<>();
    private Map<Integer, Boolean> isUnique = new HashMap<>();

    public FirstUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && !isUnique.get(queue.peek())) {
            queue.remove();
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public void add(int value) {
        if (!isUnique.containsKey(value)) {
            isUnique.put(value, true);
            queue.add(value);
        } else {
            isUnique.put(value, false);
        }
    }
}