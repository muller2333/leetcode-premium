package no3062;

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
    public String gameResult(ListNode head) {
        int count = 0;
        while (head != null) {
            int value = head.val;
            head = head.next;
            int diff = value - head.val;
            if (diff < 0) {
                count++;
            } else if (diff > 0) {
                count--;
            }
            head = head.next;
        }
        return count == 0 ? "Tie" : count > 0 ? "Odd" : "Even";
    }
}