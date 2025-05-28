package no1213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        for (int i : arr1) {
            if (Arrays.binarySearch(arr2, i) >= 0 && Arrays.binarySearch(arr3, i) >= 0) {
                res.add(i);
            }
        }
        return res;
    }
}