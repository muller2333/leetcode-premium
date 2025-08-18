package no1166;

import java.util.HashMap;
import java.util.Map;

class FileSystem {
    Map<String, Integer> map = new HashMap<>();

    public FileSystem() {

    }

    public boolean createPath(String path, int value) {
        if (map.containsKey(path)) {
            return false;
        } else {
            int idx = path.lastIndexOf("/");
            if (idx == 0) {
                return map.putIfAbsent(path, value) == null;
            } else {
                String parent = path.substring(0, idx);
                if (map.containsKey(parent)) {
                    map.put(path, value);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}