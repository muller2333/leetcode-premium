package no1500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class FileSharing {
    int val = 1;
    Queue<Integer> q = new PriorityQueue<>();
    Map<Integer, Set<Integer>> chunkMap = new HashMap<>();
    Map<Integer, Set<Integer>> userMap = new HashMap<>();

    public FileSharing(int m) {

    }

    public int join(List<Integer> ownedChunks) {
        int id;
        if (q.size() == 0) {
            id = val++;
        } else {
            id = q.poll();
        }
        userMap.putIfAbsent(id, new HashSet<>());
        for (int i : ownedChunks) {
            chunkMap.putIfAbsent(i, new TreeSet<>());
            chunkMap.get(i).add(id);
            userMap.get(id).add(i);
        }
        return id;
    }

    public void leave(int userID) {
        q.add(userID);
        Set<Integer> set = userMap.remove(userID);
        for (int i : set) {
            chunkMap.get(i).remove(userID);
        }

    }

    public List<Integer> request(int userID, int chunkID) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = chunkMap.getOrDefault(chunkID, new TreeSet<>());
        if (set.size() != 0) {
            for (int i : set) {
                res.add(i);
            }
            set.add(userID);
            chunkMap.put(chunkID, set);
            userMap.putIfAbsent(userID, new HashSet<>());
            userMap.get(userID).add(chunkID);
        }
        return res;
    }
}

/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */
