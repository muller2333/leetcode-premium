package no544;

import java.util.List;
import java.util.ArrayList;

class Solution {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        int i = 1;
        int j = n;
        while (i < j) {
            list.add("(" + i++ + "," + j-- + ")");
        }
        int size;
        while ((size = list.size()) > 1) {
            List<String> mid = new ArrayList<>();
            i = 0;
            j = size - 1;
            while (i < j) {
                mid.add("(" + list.get(i++) + "," + list.get(j--) + ")");
            }
            list = mid;
        }
        return list.get(0);
    }
}