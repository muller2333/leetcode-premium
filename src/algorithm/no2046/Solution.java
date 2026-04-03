package no2046;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode sortLinkedList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (head != null) {
            int val = head.val;
            if (val >= 0) {
                list.add(val);
            } else {
                list2.add(val);
            }
            head = head.next;
        }
        Collections.reverse(list2);
        ListNode node = new ListNode(0);
        ListNode ln = node;
        for (int i : list2) {
            head = new ListNode(i);
            ln.next = head;
            ln = head;
        }
        for (int i : list) {
            head = new ListNode(i);
            ln.next = head;
            ln = head;
        }
        return node.next;

    }
}