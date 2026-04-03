package no369;

import java.util.ArrayList;
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
    public ListNode plusOne(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode res = head;
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode node = list.get(i);
            int sum = node.val + 1;
            list.get(i).val = sum % 10;
            if (sum < 10) {
                break;
            }
        }
        if (list.get(0).val == 0) {
            ListNode node = new ListNode(1);
            node.next = res;
            res = node;
        }
        return res;
    }
}