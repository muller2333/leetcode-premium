package no3294;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    public int val;
    public Node prev;
    public Node next;
};

class Solution {
    public int[] toArray(Node node) {
        Node head = node.prev;
        List<Integer> next = new ArrayList<>();
        while (node != null) {
            next.add(node.val);
            node = node.next;
        }
        List<Integer> prev = new ArrayList<>();
        while (head != null) {
            prev.add(head.val);
            head = head.prev;
        }
        int size = prev.size();
        int size2 = next.size();
        int[] res = new int[size + size2];
        Collections.reverse(prev);
        for (int i = 0; i < size; i++) {
            res[i] = prev.get(i);
        }
        for (int i = 0; i < size2; i++) {
            res[i + size] = next.get(i);
        }
        return res;
    }
}
