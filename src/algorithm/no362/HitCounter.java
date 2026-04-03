package no362;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HitCounter {
    List<Integer> list = new ArrayList<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
        list.add(timestamp);
    }

    public int getHits(int timestamp) {
        return searchRight(timestamp) - searchLeft(timestamp - 299) + 1;
    }

    public int searchLeft(int target) {
        int search = Collections.binarySearch(list, target);
        if (search >= 0) {
            int left = 0;
            int right = search;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) == target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            search = left;
        } else {
            search = -search - 1;
        }
        return search;
    }

    public int searchRight(int target) {
        int search = Collections.binarySearch(list, target);
        if (search >= 0) {
            int left = search;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) == target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            search = right;
        } else {
            search = -search - 2;
        }
        return search;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */