package no1167;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int connectSticks(int[] sticks) {
        int length = sticks.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(sticks[i]);
        }
        Collections.sort(list);
        int res = 0;
        while (list.size() > 1) {
            int target = list.remove(0) + list.remove(0);
            res += target;
            int search = Collections.binarySearch(list, target);
            if (search < 0) {
                search = -search - 1;
            }
            list.add(search, target);
        }
        return res;
    }
}