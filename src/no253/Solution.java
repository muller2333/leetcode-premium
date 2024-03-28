package no253;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] interval : intervals) {
            int key = interval[0];
            List<Integer> rightNumList = map.get(key);
            int val = interval[1];
            if (rightNumList == null) {
                list.add(key);
                rightNumList = new ArrayList<>();
                rightNumList.add(val);
                map.put(key, rightNumList);
            } else {
                rightNumList.add(val);
            }
        }
        Set<Integer> flagSet = new HashSet<>();
        Collections.sort(list);
        int res = 0;
        while (list.size() > 0) {
            int left = list.get(0);
            List<Integer> rightNumList = map.get(left);
            if (!flagSet.contains(left)) {
                Collections.sort(rightNumList);
            }
            int prev = rightNumList.remove(0);
            if (rightNumList.size() == 0) {
                list.remove(0);
                map.remove(left);
            }
            int search = 0;
            while (search < list.size()) {
                search = Collections.binarySearch(list, prev);
                if (search < 0) {
                    search = -search - 1;
                }
                if (search < list.size()) {
                    left = list.get(search);
                    rightNumList = map.get(left);
                    if (!flagSet.contains(left)) {
                        Collections.sort(rightNumList);
                    }
                    prev = rightNumList.remove(0);
                    if (rightNumList.size() == 0) {
                        list.remove(search);
                        map.remove(left);
                    }
                }
            }
            res++;
        }
        return res;
    }
}
