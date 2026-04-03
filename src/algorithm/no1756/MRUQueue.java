package no1756;

import java.util.ArrayList;
import java.util.List;

class MRUQueue {
    List<Integer> list = new ArrayList<>();

    public MRUQueue(int n) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }

    public int fetch(int k) {
        int res = list.remove(k - 1);
        list.add(res);
        return res;
    }
}