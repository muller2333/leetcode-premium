package no244;

import java.util.*;

class WordDistance {
    int max;
    Map<String, List<Integer>> map = new HashMap<>();
    Map<String, Integer> resMap = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        this.max = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }


    public int shortest(String word1, String word2) {
        String key = word1 + "," + word2;
        String key2 = word2 + "," + word1;
        Integer val = resMap.get(key);
        Integer val2 = resMap.get(key2);
        if (val != null) {
            return val;
        }
        if (val2 != null) {
            return val2;
        }
        int res = max;
        List<Integer> list = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int size = list.size();
        int size2 = list2.size();
        if (size < size2) {
            for (int i : list) {
                int search = -Collections.binarySearch(list2, i) - 1;
                if (search == 0) {
                    res = Math.min(list2.get(0) - i, res);
                } else if (search == size2) {
                    res = Math.min(i - list2.get(size2 - 1), res);
                } else {
                    res = Math.min(Math.min(i - list2.get(search - 1), list2.get(search) - i), res);
                }
            }
        } else {
            for (int i : list2) {
                int search = -Collections.binarySearch(list, i) - 1;
                if (search == 0) {
                    res = Math.min(list.get(0) - i, res);
                } else if (search == size) {
                    res = Math.min(i - list.get(size - 1), res);
                } else {
                    res = Math.min(Math.min(i - list.get(search - 1), list.get(search) - i), res);
                }
            }
        }
        resMap.put(key, res);
        resMap.put(key2, res);
        return res;
    }
}