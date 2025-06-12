package no683;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        int length = bulbs.length;
        List<Integer> list = new ArrayList<>(length);
        int res = 1;
        for (int i : bulbs) {
            if (list.size() == 0) {
                list.add(i);
            } else {
                int idx = -Collections.binarySearch(list, i) - 1;
                if (idx == 0) {
                    if (list.get(idx) == i + k + 1) {
                        return res;
                    }
                    list.add(0, i);
                } else if (idx == list.size()) {
                    if (list.get(list.size() - 1) + k + 1 == i) {
                        return res;
                    }
                    list.add(i);
                } else {
                    if (list.get(idx) == i + k + 1 || list.get(idx - 1) + k + 1 == i) {
                        return res;
                    }
                    list.add(idx, i);

                }
            }
            res++;
        }
        return -1;
    }
}
