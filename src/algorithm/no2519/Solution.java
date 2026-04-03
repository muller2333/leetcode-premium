package no2519;

import java.util.*;

class Solution {
    public int kBigIndices(int[] nums, int k) {
        int length = nums.length;
        List<Integer> leftList = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            leftList.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = k; i < length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Collections.sort(leftList);
        int sum = 0;
        for (int num : map.keySet()) {
            map2.put(num, sum);
            sum += map.get(num);
        }
        int res = 0;
        for (int i = k; i < length - k; i++) {
            int target = nums[i];
            int count;
            int search = Collections.binarySearch(leftList, target);
            if (search < 0) {
                search = -search - 1;
                if (search < k) {
                    leftList.add(search, target);
                    continue;
                }
                count = search;
            } else {
                int left = 0;
                int right = search;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (leftList.get(mid) == target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                if (left < k) {
                    leftList.add(search, target);
                    continue;
                }
                count = right + 1;
            }
            leftList.add(search, target);
            if (map2.get(target) - count >= k) {
                res++;
            }
        }
        return res;
    }

}