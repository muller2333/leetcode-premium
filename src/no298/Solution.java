package no298;

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
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        traverse(root, 1);
        return res;
    }

    public void traverse(TreeNode root, int length) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null) {
                if (left.val == root.val + 1) {
                    traverse(left, length + 1);
                } else {
                    traverse(left, 1);
                }
            }
            if (right != null) {
                if (right.val == root.val + 1) {
                    traverse(right, length + 1);
                } else {
                    traverse(right, 1);
                }
            }
        }
        res = Math.max(res, length);
    }
}