package no708;

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}

class Solution {
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if (head == null) {
            insert.next = insert;
            return insert;
        }
        Node res = head;
        if (head == head.next) {
            head.next = insert;
            insert.next = head;
        } else {
            if (head.val > insertVal || head.next.val < insertVal) {
                head = head.next;
            }
            while ((head.val > insertVal || head.next.val < insertVal) && head.val <= head.next.val && res != head) {
                head = head.next;
            }
            if (head.val > insertVal && head.next.val < insertVal) {
                do {
                    head = head.next;
                } while ((head.val > insertVal || head.next.val < insertVal));
            }
            Node next = head.next;
            head.next = insert;
            insert.next = next;
        }
        return res;
    }
}