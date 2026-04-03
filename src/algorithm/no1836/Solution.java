package no1836;

import java.util.LinkedHashMap;
import java.util.Map;

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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        while (head != null) {
            int val = head.val;
            map.put(val, map.getOrDefault(val, 0) + 1);
            head = head.next;
        }
        head = new ListNode(0);
        ListNode node = head;
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                ListNode ln = new ListNode(num);
                node.next = ln;
                node = ln;
            }
        }
        return head.next;
    }
}