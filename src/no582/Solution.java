package no582;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int size = ppid.size();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int id = ppid.get(i);
            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<>());
            }
            map.get(id).add(pid.get(i));
        }
        List<Integer> res = new ArrayList<>();
        res.add(kill);
        List<Integer> list = map.getOrDefault(kill, new ArrayList<>());
        while ((size = list.size()) > 0) {
            List<Integer> mid = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int num = list.get(i);
                res.add(num);
                if (map.containsKey(num)) {
                    mid.addAll(map.get(num));
                }
            }
            list = mid;
        }
        return res;
    }
}