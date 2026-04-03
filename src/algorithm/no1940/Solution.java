package no1940;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> res = new ArrayList<>();
        for (int i : arrays[0]) {
            res.add(i);
        }
        for (int i = 1; i < arrays.length; i++) {
            int[] arr = arrays[i];
            List<Integer> mid = new ArrayList<>();
            if (res.size() < arr.length) {
                for (int num : res) {
                    int search = Arrays.binarySearch(arr, num);
                    if (search >= 0) {
                        mid.add(num);
                    }
                }
            } else {
                for (int num : arr) {
                    int search = Collections.binarySearch(res, num);
                    if (search >= 0) {
                        mid.add(num);
                    }
                }
            }
            if (mid.size() == 0) {
                return mid;
            } else {
                res = mid;
            }
        }
        return res;
    }
}