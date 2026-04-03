package no1244;

import java.util.*;

class Leaderboard {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    public Leaderboard() {

    }

    public void addScore(int playerId, int score) {
        int val = map.getOrDefault(playerId, 0);
        if (val != 0) {
            list.remove(Collections.binarySearch(list, val));
            score += val;
        }
        int search = Collections.binarySearch(list, score);
        if (search < 0) {
            search = -search - 1;
        }
        list.add(search, score);
        map.put(playerId, score);
    }

    public int top(int K) {
        int size = list.size();
        int sum = 0;
        for (int i = size - K; i < size; i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public void reset(int playerId) {
        list.remove(Collections.binarySearch(list, map.remove(playerId)));
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
