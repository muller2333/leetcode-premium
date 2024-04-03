package no624;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            for (int j : arrays.get(i)) {
                list.add(new int[] { j, i });
            }
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        int size = list.size();
        int j = size - 1;
        int res = 0;
        while (0 < j) {
            if (list.get(j)[1] != list.get(0)[1]) {
                res = Math.max(list.get(j)[0] - list.get(0)[0], res);
                break;
            }
            j--;
        }
        j = 0;
        while (j < size) {
            if (list.get(j)[1] != list.get(size - 1)[1]) {
                res = Math.max(list.get(size - 1)[0] - list.get(j)[0], res);
                break;
            }
            j++;
        }
        return res;
    }
}
