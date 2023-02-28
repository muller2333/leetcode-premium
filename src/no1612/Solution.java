package no1612;

class Node {
    char val;
    Node left;
    Node right;

    Node() {
        this.val = ' ';
    }

    Node(char val) {
        this.val = val;
    }

    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        traverse(root1, arr);
        traverse(root2, arr2);
        for (int i = 0; i < 26; i++) {
            if (arr[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public void traverse(Node node, int[] arr) {
        if (node != null) {
            traverse(node.left, arr);
            if (node.val != '+') {
                arr[node.val - 'a']++;
            }
            traverse(node.right, arr);
        }
    }
}