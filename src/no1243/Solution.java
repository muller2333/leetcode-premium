package no1243;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> transformArray(int[] arr) {
        int length = arr.length;
        int[] changes = new int[length];
        List<Integer> res = new ArrayList<>();
        while (true) {
            boolean flag = true;
            for (int i = 1; i < length - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    changes[i] = 1;
                    flag = false;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    changes[i] = -1;
                    flag = false;
                }
            }
            if (flag) {
                for (int i : arr) {
                    res.add(i);
                }
                break;
            } else {
                for (int i = 1; i < length - 1; i++) {
                    arr[i] += changes[i];
                }
                changes = new int[length];
            }
        }
        return res;
    }
}