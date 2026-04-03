package no3369;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

class StatisticsTracker {
    long sum = 0;
    Queue<Integer> q = new ArrayDeque<>();
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    TreeMap<Integer, TreeSet<Integer>> tm = new TreeMap<>();

    public StatisticsTracker() {

    }

    public void addNumber(int number) {
        sum += number;
        q.add(number);
        int idx = Collections.binarySearch(list, number);
        if (idx < 0) {
            idx = -idx - 1;
        }
        list.add(idx, number);
        int oldCount = map.getOrDefault(number, 0);
        if (oldCount != 0) {
            TreeSet<Integer> set = tm.get(oldCount);
            set.remove(number);
            if (set.size() == 0) {
                tm.remove(oldCount);
            }
        }
        tm.putIfAbsent(oldCount + 1, new TreeSet<>());
        tm.get(oldCount + 1).add(number);
        map.merge(number, 1, Integer::sum);
    }

    public void removeFirstAddedNumber() {
        int poll = q.poll();
        sum -= poll;
        list.remove(Collections.binarySearch(list, poll));
        int oldCount = map.get(poll);
        TreeSet<Integer> set = tm.get(oldCount);
        set.remove(poll);
        if (set.size() == 0) {
            tm.remove(oldCount);
        }
        if (oldCount == 1) {
            map.remove(poll);
        } else {
            map.put(poll, oldCount - 1);
            tm.putIfAbsent(oldCount - 1, new TreeSet<>());
            tm.get(oldCount - 1).add(poll);
        }
    }

    public int getMean() {
        return (int) (sum / q.size());
    }

    public int getMedian() {
        return list.get(q.size() / 2);
    }

    public int getMode() {
        int max = tm.floorKey(100_000);
        TreeSet<Integer> set = tm.get(max);
        return set.ceiling(0);
    }
}