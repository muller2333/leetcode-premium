package no3422;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long minOperations(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
            sum += nums[i];
        }
        Collections.sort(list);
        long leftSum = 0;
        int limit = k / 2;
        for (int i = 0; i < limit; i++) {
            leftSum += list.get(i);
        }
        long res = sum - 2 * leftSum - (k % 2 == 0 ? 0 : list.get(k / 2));
        for (int i = 1; i <= length - k; i++) {
            int toDel = nums[i - 1];
            int toAdd = nums[i + k - 1];
            sum += toAdd - toDel;
            if (list.get(k / 2 - 1) >= toDel) {
                leftSum += list.get(k / 2) - toDel;
            }
            list.remove(Collections.binarySearch(list, toDel));
            if (list.get(k / 2 - 1) > toAdd) {
                leftSum += toAdd - list.get(k / 2 - 1);
            }
            int idx = Collections.binarySearch(list, toAdd);
            if (idx < 0) {
                idx = -idx - 1;
            }
            list.add(idx, toAdd);
            res = Math.min(res, sum - 2 * leftSum - (k % 2 == 0 ? 0 : list.get(k / 2)));
        }
        return res;
    }
}
