package no1426;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int num = arr[i];
            if (set.contains(num)) {
                res++;
            } else {
                if (Arrays.binarySearch(arr, i + 1, arr.length, num + 1) > i) {
                    set.add(num);
                    res++;
                }
            }
        }
        return res;
    }
}