package no2674;

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
    public ListNode[] splitCircularLinkedList(ListNode list) {
        ListNode firstHead = list;
        int count = 0;
        do {
            count++;
            list = list.next;
        } while (list != firstHead);
        count = ++count >> 1;
        while (count > 1) {
            count--;
            list = list.next;
        }
        ListNode secondHead = list.next;
        list.next = firstHead;
        list = secondHead;
        while (list.next != firstHead) {
            list = list.next;
        }
        list.next = secondHead;
        return new ListNode[] { firstHead, secondHead };
    }
}
