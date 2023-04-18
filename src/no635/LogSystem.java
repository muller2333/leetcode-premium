package no635;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LogSystem {
    Map<Integer, String> map = new HashMap<>();
    Map<String, Integer> granularityMap = new HashMap<>();

    public LogSystem() {
        granularityMap.put("Year", 4);
        granularityMap.put("Month", 7);
        granularityMap.put("Day", 10);
        granularityMap.put("Hour", 13);
        granularityMap.put("Minute", 16);
        granularityMap.put("Second", 19);
    }

    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> res = new ArrayList<>();
        int length = granularityMap.get(granularity);
        start = start.substring(0, length);
        end = end.substring(0, length);
        for (int key : map.keySet()) {
            String timestamp = map.get(key);
            timestamp = timestamp.substring(0, length);
            if (timestamp.compareTo(start) >= 0 && timestamp.compareTo(end) <= 0) {
                res.add(key);
            }
        }
        return res;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
