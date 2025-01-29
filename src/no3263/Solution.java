package no3263;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node prev;
    public Node next;
};

class Solution {
    public int[] toArray(Node head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
