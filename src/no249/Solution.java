package no249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            int length = s.length();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length - 1; j++) {
                int diff = s.charAt(j + 1) - s.charAt(j);
                if (diff < 0) {
                    diff += 26;
                }
                sb.append(diff).append(',');
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

}