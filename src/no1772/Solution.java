package no1772;

import java.util.*;

class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> map = new HashMap<>();
        int length = features.length;
        for (int i = 0; i < length; i++) {
            map.put(features[i], 0);
        }
        for (String response : responses) {
            String[] strings = response.split(" ");
            Set<String> set = new HashSet<>();
            for (String s : strings) {
                if (!set.contains(s)) {
                    set.add(s);
                    if (map.containsKey(s)) {
                        map.put(s, map.get(s) + 1);
                    }
                }
            }
        }
        Map<Integer, List<String>> resMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (String feature : features) {
            int count = map.get(feature);
            if (!resMap.containsKey(count)) {
                resMap.put(count, new ArrayList<>());
            }
            resMap.get(count).add(feature);
        }
        int i = 0;
        String[] res = new String[length];
        for (int count : resMap.keySet()) {
            List<String> list = resMap.get(count);
            for (String s : list) {
                res[i++] = s;
            }
        }
        return res;
    }
}