package no3773;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            list.add(i + 1);
        }
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.binarySearch(arr, 0, 2, 3));
    }

    public int maxSameLengthRuns(String s) {
        char[] chars = (s + "A").toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                map.merge(count, 1, Integer::sum);
                count = 1;
            }
        }
        int res = 0;
        for (int val : map.values()) {
            res = Math.max(res, val);
        }
        return res;
    }
}
