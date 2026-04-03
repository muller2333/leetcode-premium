package no510;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

class Solution {
    public Node inorderSuccessor(Node node) {
        Node right = node.right;
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
        Node parent = node.parent;
        while (parent != null && parent.val < node.val) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }
}