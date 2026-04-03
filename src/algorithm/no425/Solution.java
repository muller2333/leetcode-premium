package no425;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        int length = words.length;
        int len = words[0].length();
        List<List<String>> res = new ArrayList<>();
        if (len == 1) {
            for (String word : words) {
                List<String> list = new ArrayList<>();
                list.add(word);
                res.add(list);
            }
        } else if (len == 2) {
            for (String word : words) {
                for (String w : words) {
                    if (word.charAt(1) == w.charAt(0)) {
                        List<String> list = new ArrayList<>();
                        list.add(word);
                        list.add(w);
                        res.add(list);
                    }
                }
            }
        } else if (len == 3) {
            Set<String> set = new HashSet<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String word : words) {
                set.add(word);
                String pre = word.substring(0, 2);
                map.putIfAbsent(pre, new ArrayList<>());
                map.get(pre).add(word);
            }
            char[][] chars = new char[3][3];
            for (int i = 0; i < length; i++) {
                chars[0] = words[i].toCharArray();
                chars[1][0] = chars[0][1];
                chars[2][0] = chars[0][2];
                for (char j = 'a'; j <= 'z'; j++) {
                    chars[1][1] = j;
                    for (char k = 'a'; k <= 'z'; k++) {
                        chars[1][2] = k;
                        String target = new String(chars[1]);
                        if (set.contains(target)) {
                            chars[2][1] = k;
                            for (String word : map.getOrDefault("" + chars[2][0] + chars[2][1],
                                    new ArrayList<>())) {
                                List<String> list = new ArrayList<>();
                                list.add(words[i]);
                                list.add(target);
                                list.add(word);
                                res.add(list);
                            }
                        }
                    }
                }
            }
        } else {
            Set<String> set = new HashSet<>();
            Set<String> preSet = new HashSet<>();
            for (String word : words) {
                set.add(word);
                String pre = word.substring(0, 3);
                preSet.add(pre);
            }
            char[][] chars = new char[4][4];
            for (int i = 0; i < length; i++) {
                chars[0] = words[i].toCharArray();
                for (int x = 0; x < length; x++) {
                    String second = words[x];
                    if (second.charAt(0) == chars[0][1]) {
                        chars[1] = second.toCharArray();
                        chars[2][0] = chars[0][2];
                        chars[2][1] = chars[1][2];
                        chars[3][0] = chars[0][3];
                        chars[3][1] = chars[1][3];
                        for (char j = 'a'; j <= 'z'; j++) {
                            chars[3][2] = j;
                            String pre = new String(chars[3], 0, 3);
                            if (preSet.contains(pre)) {
                                chars[2][3] = j;
                                for (char k = 'a'; k <= 'z'; k++) {
                                    String four = pre + k;
                                    if (set.contains(four)) {
                                        for (char m = 'a'; m <= 'z'; m++) {
                                            chars[2][2] = m;
                                            String third = new String(chars[2]);
                                            if (set.contains(third)) {
                                                List<String> list = new ArrayList<>();
                                                list.add(words[i]);
                                                list.add(second);
                                                list.add(third);
                                                list.add(four);
                                                res.add(list);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
