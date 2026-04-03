package no1634;

import java.util.Collections;
import java.util.TreeMap;

class PolyNode {
    int coefficient, power;
    PolyNode next = null;

    PolyNode() {
    }

    PolyNode(int x, int y) {
        this.coefficient = x;
        this.power = y;
    }

    PolyNode(int x, int y, PolyNode next) {
        this.coefficient = x;
        this.power = y;
        this.next = next;
    }
}

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode res = new PolyNode();
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        while (poly1 != null) {
            map.put(poly1.power, poly1.coefficient);
            poly1 = poly1.next;
        }
        while (poly2 != null) {
            map.merge(poly2.power, poly2.coefficient, Integer::sum);
            poly2 = poly2.next;
        }
        PolyNode cur = res;
        for (int key : map.keySet()) {
            int c = map.get(key);
            if (c != 0) {
                PolyNode next = new PolyNode(c, key);
                cur.next = next;
                cur = next;
            }
        }
        return res.next;
    }
}
