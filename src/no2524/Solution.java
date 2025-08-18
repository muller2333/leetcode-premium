package no2524;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int maxFrequencyScore(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> resMap = new HashMap<>();
        int MOD = 1_000_000_007;
        int res = 0;
        for (int i = 0; i < k; i++) {
            map.merge(nums[i], 1, Integer::sum);
            List<Integer> list = resMap.get(nums[i]);
            if (list == null) {
                resMap.put(nums[i], new ArrayList<>());
                resMap.get(nums[i]).add(nums[i]);
            } else {
                list.add((int) ((1L * list.get(list.size() - 1) * nums[i]) % MOD));
            }
        }
        for (List<Integer> values : resMap.values()) {
            res = (res + values.get(values.size() - 1)) % MOD;
        }
        int sum = res;
        int length = nums.length;
        for (int i = k; i < length; i++) {
            if (nums[i] != nums[i - k]) {
                List<Integer> list = resMap.get(nums[i]);
                if (list == null) {
                    sum += nums[i];
                    resMap.put(nums[i], new ArrayList<>());
                    resMap.get(nums[i]).add(nums[i]);
                } else {
                    int size = list.size();
                    int count = map.get(nums[i]);
                    if (size == count) {
                        list.add((int) ((1L * list.get(list.size() - 1) * nums[i]) % MOD));
                        sum = (sum - list.get(size - 1) + list.get(size)) % MOD;
                    } else {
                        if (count == 0) {
                            sum += nums[i];
                        } else {
                            sum = (sum - list.get(count - 1) + list.get(count)) % MOD;
                        }
                    }
                }
                List<Integer> li = resMap.get(nums[i - k]);
                int count = map.get(nums[i - k]);
                if (count == 1) {
                    sum -= li.get(0);
                } else {
                    sum = (sum - li.get(count - 1) + li.get(count - 2)) % MOD;
                }
                map.merge(nums[i], 1, Integer::sum);
                map.merge(nums[i - k], -1, Integer::sum);
                res = Math.max(res, (sum + MOD) % MOD);
            }
        }
        return res;
    }
}
