package no1265;

interface ImmutableListNode {
    void printValue();

    ImmutableListNode getNext();
};

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        ImmutableListNode target = null;
        while (head != target) {
            ImmutableListNode node = head;
            while (node.getNext() != target) {
                node = node.getNext();
            }
            node.printValue();
            target = node;
        }

    }
}