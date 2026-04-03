package no1474;

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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode node = head;
        ListNode slow = head;
        int count = 0;
        int limit = m + n - 1;
        while (head != null) {
            if (count < m) {
                slow = head;
            } else if (count < limit) {
                slow.next = null;
            } else if (count == limit) {
                slow.next = head.next;
                count = -1;
            }
            count++;
            head = head.next;
        }
        return node;
    }
}