package no527;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        int size = words.size();
        Map<String, Integer> idxMap = new HashMap<>();
        Map<Integer, Map<String, List<String>>> map = new HashMap<>();
        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            String word = words.get(i);
            int length = word.length();
            if (length <= 3) {
                res[i] = word;
            } else {
                String key = "" + word.charAt(0) + word.charAt(length - 1);
                map.putIfAbsent(length, new HashMap<>());
                Map<String, List<String>> inner = map.get(length);
                inner.putIfAbsent(key, new ArrayList<>());
                inner.get(key).add(word);
                idxMap.put(word, i);
            }
        }
        for (Map<String, List<String>> inner : map.values()) {
            for (List<String> list : inner.values()) {
                size = list.size();
                int length = list.get(0).length();
                if (size == 1) {
                    String word = list.get(0);
                    res[idxMap.get(word)] = "" + word.charAt(0) + (length - 2) + word.charAt(length - 1);
                } else {
                    Map<String, Integer> countMap = new HashMap<>();
                    for (String word : list) {
                        char[] chars = word.toCharArray();
                        for (int i = 2; i <= length - 1; i++) {
                            countMap.merge(new String(chars, 0, i), 1, Integer::sum);
                        }
                    }
                    for (String word : list) {
                        int idx = idxMap.get(word);
                        char[] chars = word.toCharArray();
                        for (int i = 2; i <= length - 1; i++) {
                            String prefix = new String(chars, 0, i);
                            if (countMap.get(prefix) == 1) {
                                if (i <= length - 3) {
                                    res[idx] = word.substring(0, i) + (length - i - 1)
                                            + chars[length - 1];
                                } else {
                                    res[idx] = word;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        return Arrays.asList(res);
    }
}
