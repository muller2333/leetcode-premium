package no250;

import common.TreeNode;

class Solution {
    int res;

    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root);
        return res;
    }

    public boolean isUnival(TreeNode node) {
        if (node != null) {
            int val = node.val;
            int leftVal = val;
            TreeNode left = node.left;
            if (left != null) {
                leftVal = left.val;
            }
            boolean leftFlag = isUnival(left);
            int rightVal = val;
            TreeNode right = node.right;
            if (right != null) {
                rightVal = right.val;
            }
            boolean rightFlag = isUnival(right);
            if (leftFlag && rightFlag && val == leftVal && val == rightVal) {
                res++;
            } else {
                return false;
            }
        }
        return true;
    }
}