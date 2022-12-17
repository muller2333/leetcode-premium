package no1650;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> list = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        while (p != null) {
            list.add(p);
            p = p.parent;
        }
        while (q != null) {
            list2.add(q);
            q = q.parent;
        }
        Collections.reverse(list);
        Collections.reverse(list2);
        int size = Math.min(list.size(), list2.size());
        Node res = null;
        for (int i = 0; i < size; i++) {
            if (list.get(i) == list2.get(i)) {
                res = list.get(i);
            } else {
                return res;
            }
        }
        return res;
    }
}