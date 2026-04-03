package no1858;

import java.util.*;

class Solution {
    public String longestWord(String[] words) {
        Map<Integer, List<String>> map = new TreeMap<>((a, b) -> b - a);
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
            int length = word.length();
            if (!map.containsKey(length)) {
                map.put(length, new ArrayList<>());
            }
            map.get(length).add(word);
        }
        for (int length : map.keySet()) {
            List<String> strings = map.get(length);
            Collections.sort(strings);
            for (String word : strings) {
                int len = word.length();
                StringBuilder sb = new StringBuilder();
                boolean flag = true;
                for (int i = 0; i < len; i++) {
                    sb.append(word.charAt(i));
                    if (!set.contains(sb.toString())) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return word;
                }
            }
        }
        return "";
    }
}