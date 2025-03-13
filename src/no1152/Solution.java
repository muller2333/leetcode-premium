package no1152;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int length = username.length;
        Map<String, Map<Integer, String>> map = new HashMap<>();
        Map<String, Set<String>> countMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String uname = username[i];
            map.putIfAbsent(uname, new TreeMap<>());
            map.get(uname).put(timestamp[i], website[i]);
        }
        for (String key : map.keySet()) {
            List<String> list = new ArrayList<>();
            for (String web : map.get(key).values()) {
                list.add(web);
            }
            int size = list.size();
            for (int i = 0; i < size - 2; i++) {
                for (int j = i + 1; j < size - 1; j++) {
                    for (int k = j + 1; k < size; k++) {
                        String pattern = list.get(i) + "," + list.get(j) + "," + list.get(k);
                        countMap.putIfAbsent(pattern, new HashSet<>());
                        countMap.get(pattern).add(key);
                    }
                }
            }
        }
        int max = 0;
        String res = "";
        for (String key : countMap.keySet()) {
            Set<String> values = countMap.get(key);
            int size = values.size();
            if (size > max) {
                max = size;
                res = key;
            } else if (size == max && key.compareTo(res) < 0) {
                res = key;
            }
        }
        return Arrays.asList(res.split(","));
    }
}
