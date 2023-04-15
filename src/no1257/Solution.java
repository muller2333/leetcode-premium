package no1257;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> map = new HashMap<>();
        for (List<String> region : regions) {
            int size = region.size();
            String parent = region.get(0);
            for (int i = 1; i < size; i++) {
                map.put(region.get(i), parent);
            }
        }
        if (map.get(region1).equals(region2)) {
            return region2;
        }
        if (map.get(region2).equals(region1)) {
            return region1;
        }
        List<String> list = new ArrayList<>();
        list.add(region1);
        String parent;
        while ((parent = map.get(region1)) != null) {
            list.add(parent);
            region1 = parent;
        }
        List<String> list2 = new ArrayList<>();
        list2.add(region2);
        while ((parent = map.get(region2)) != null) {
            list2.add(parent);
            region2 = parent;
        }
        int i = list.size() - 1;
        int j = list2.size() - 1;
        String res = null;
        while (i >= 0 && j >= 0 && list.get(i).equals(list2.get(j))) {
            res = list.get(i--);
            j--;
        }
        return res;
    }
}