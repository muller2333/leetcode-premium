package no1788;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumBeauty(int[] flowers) {
        int length = flowers.length;
        Map<Integer, int[]> map = new HashMap<>();
        int[] sums = new int[length + 1];
        for (int i = 0; i < length; i++) {
            int num = flowers[i];
            int[] arr = map.get(num);
            if (arr == null) {
                map.put(num, new int[] { i, i });
            } else {
                arr[1] = i;
            }
            sums[i + 1] = sums[i] + Math.max(0, num);
        }
        int res = -1_000_000_000;
        for (int key : map.keySet()) {
            int[] arr = map.get(key);
            if (arr[0] != arr[1]) {
                res = Math.max(res, sums[arr[1] + 1] - sums[arr[0]] + Math.min(2 * key, 0));
            }
        }
        return res;
    }
}
