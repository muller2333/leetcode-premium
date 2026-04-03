package no3119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maxPotholes(String road, int budget) {
        char[] chars = road.toCharArray();
        int i = 0;
        List<Integer> list = new ArrayList<>();
        int length = chars.length;
        while (i < length) {
            if (chars[i] == 'x') {
                int count = 1;
                while (++i < length && chars[i] == 'x') {
                    count++;
                }
                list.add(count);
            }
            i++;
        }
        Collections.sort(list);
        int res = 0;
        for (i = list.size() - 1; i >= 0; i--) {
            int count = list.get(i);
            if (count + 1 < budget) {
                res += count;
                budget -= count + 1;
            } else {
                res += budget - 1;
                break;
            }
        }
        return res;
    }
}
