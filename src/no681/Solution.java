package no681;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        set.add(time.charAt(0) - '0');
        set.add(time.charAt(1) - '0');
        set.add(time.charAt(3) - '0');
        set.add(time.charAt(4) - '0');
        List<Integer> list = new ArrayList<>();
        backTrace(new StringBuilder(), set, 0, list);
        int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int min = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        int target = hour * 60 + min;
        int idx = Collections.binarySearch(list, target);
        target = list.get((idx + 1) % list.size());
        hour = target / 60;
        min = target % 60;
        return (hour < 10 ? "0" + hour : hour) + ":" + (min < 10 ? "0" + min : min);
    }

    public void backTrace(StringBuilder sb, Set<Integer> set, int i, List<Integer> list) {
        if (sb.length() == 4) {
            int hour = (sb.charAt(0) - '0') * 10 + (sb.charAt(1) - '0');
            int min = (sb.charAt(2) - '0') * 10 + (sb.charAt(3) - '0');
            if (hour < 24 && min < 60) {
                list.add(hour * 60 + min);
            }
        } else {
            for (int num : set) {
                sb.append(num);
                backTrace(sb, set, i + 1, list);
                sb.deleteCharAt(i);
            }
        }
    }
}