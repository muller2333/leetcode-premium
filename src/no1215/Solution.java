package no1215;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        if (high <= 10) {
            for (int i = low; i <= high; i++) {
                res.add(i);
            }
        } else {
            List<Integer> list = new ArrayList<>();
            res.add(0);
            for (int i = 1; i <= 9; i++) {
                res.add(i);
                list.add(i);
            }
            while (list.size() > 0) {
                List<Integer> mid = new ArrayList<>();
                for (int i : list) {
                    int rem = i % 10;
                    long num;
                    if (rem != 0) {
                        num = i * 10L + rem - 1;
                        if (num <= high) {
                            res.add((int) num);
                        }
                        if (num < high) {
                            mid.add((int) num);
                        }
                    }
                    if (rem != 9) {
                        num = i * 10L + rem + 1;
                        if (num <= high) {
                            res.add((int) num);
                        }
                        if (num < high) {
                            mid.add((int) num);
                        }
                    }
                }
                list = mid;
            }
        }
        int idx = Collections.binarySearch(res, low);
        if (idx < 0) {
            idx = -idx - 1;
        }
        return res.subList(idx, res.size());
    }
}