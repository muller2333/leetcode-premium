package no1602;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        while ((size = queue.size()) > 0) {
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == u) {
                    if (i == size - 1) {
                        return null;
                    } else {
                        return queue.poll();
                    }
                } else {
                    TreeNode left = node.left;
                    if (left != null) {
                        queue.add(left);
                    }
                    TreeNode right = node.right;
                    if (right != null) {
                        queue.add(right);
                    }
                }
            }
        }
        return null;
    }

}