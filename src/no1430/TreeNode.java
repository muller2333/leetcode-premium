package no1430;

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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0, null);
    }

    public boolean isValidSequence(TreeNode root, int[] arr, int level, TreeNode parent) {
        if (root == null) {
            return level == arr.length && parent.left == null && parent.right == null;
        } else {
            if (level >= arr.length || root.val != arr[level]) {
                return false;
            }
            return isValidSequence(root.left, arr, level + 1, root)
                    || isValidSequence(root.right, arr, level + 1, root);
        }
    }
}