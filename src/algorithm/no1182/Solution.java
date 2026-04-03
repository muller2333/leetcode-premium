package no1182;

import java.util.*;

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 1) {
                list.add(i);
            } else if (colors[i] == 2) {
                list2.add(i);
            } else {
                list3.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, list);
        map.put(2, list2);
        map.put(3, list3);
        for (int i = 0; i < queries.length; i++) {
            List<Integer> li = map.get(queries[i][1]);
            if (li.size() == 0) {
                res.add(-1);
            } else {
                int search = Collections.binarySearch(li, queries[i][0]);
                if (search >= 0) {
                    res.add(0);
                } else {
                    search = -search - 1;
                    if (search == 0) {
                        res.add(li.get(0) - queries[i][0]);
                    } else if (search == li.size()) {
                        res.add(queries[i][0] - li.get(li.size() - 1));
                    } else {
                        res.add(Math.min(li.get(search) - queries[i][0], queries[i][0] - li.get(search - 1)));
                    }
                }
            }
        }
        return res;
    }
}