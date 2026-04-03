package no281;

import java.util.List;

public class ZigzagIterator {
    int index;
    int index2;
    int count;
    List<Integer> v1;
    List<Integer> v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (hasNext()) {
            int res;
            if (count++ % 2 == 0) {
                res = index == v1.size() ? v2.get(index2++) : v1.get(index++);
            } else {
                res = index2 == v2.size() ? v1.get(index++) : v2.get(index2++);
            }
            return res;
        }
        return -1;
    }

    public boolean hasNext() {
        return index < v1.size() || index2 < v2.size();
    }
}