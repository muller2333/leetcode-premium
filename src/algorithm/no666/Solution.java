package no666;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int pathSum(int[] nums) {
        int maxDep = 0;
        Map<Integer, int[]> map = new HashMap<>();
        Map<Integer, List<Integer>> numsMap = new HashMap<>();
        for (int num : nums) {
            int depth = num / 100;
            map.putIfAbsent(depth, new int[1 << (depth - 1)]);
            numsMap.putIfAbsent(depth, new ArrayList<>());
            numsMap.get(depth).add(num);
            maxDep = Math.max(depth, num / 100);
        }
        int res = 0;
        for (int i = maxDep; i >= 1; i--) {
            List<Integer> list = numsMap.get(i);
            int[] arr = map.get(i);
            for (int n : list) {
                int pos = (n / 10) % 10;
                int count = arr[pos - 1];
                if (count == 0) {
                    res += (n % 10);
                    arr[pos - 1] = 1;
                } else {
                    res += (n % 10) * count;
                }
                if (i != 1) {
                    map.get(i - 1)[((pos + 1) / 2) - 1] += arr[pos - 1];
                }
            }
        }
        return res;
    }
}