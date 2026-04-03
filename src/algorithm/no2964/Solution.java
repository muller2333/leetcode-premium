package no2964;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        if (nums.length < 3) {
            return 0;
        }
        int res = 0;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int remainder = num % d;
            if (map.containsKey(remainder)) {
                map.put(remainder, map.get(remainder) + 1);
            } else {
                list.add(remainder);
                map.put(remainder, 1);
            }
        }
        Collections.sort(list);
        if (list.get(0) == 0 && (map.get(0) >= 3)) {
            res += combination(map.get(0));
        }
        int[] arr = { d, d << 1 };
        int size = list.size();
        for (int n : arr) {
            for (int i = 0; i < size; i++) {
                int j = i;
                int k = size - 1;
                while (j <= k) {
                    int sum = list.get(j) + list.get(k);
                    if (sum > n - list.get(i)) {
                        k--;
                    } else if (sum < n - list.get(i)) {
                        j++;
                    } else {
                        if (j == k) {
                            if (i == j) {
                                res += map.get(list.get(i)) >= 3 ? combination(map.get(list.get(i))) : 0;
                            } else {
                                res += map.get(list.get(i)) * (map.get(list.get(j)) - 1) * map.get(list.get(j)) / 2;

                            }
                        } else {
                            if (i == j) {
                                res += map.get(list.get(k)) * (map.get(list.get(j)) - 1) * map.get(list.get(j)) / 2;
                            } else {
                                res += map.get(list.get(k)) * map.get(list.get(j)) * map.get(list.get(i));
                            }
                        }
                        j++;
                        k--;
                    }
                }
            }
        }
        return res;
    }

    public static int combination(int n) {
        if (n == 3) {
            return 1;
        }
        if (n == 4) {
            return 4;
        }
        if (n == 5) {
            return 10;
        }
        int a = 1, b = 1;
        for (int i = 1; i <= 3; i++) {
            a *= (n + 1 - i);
            b *= i;
        }
        return a / b;
    }
}