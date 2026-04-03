package no1120;

import common.TreeNode;

class Solution {
    double res = 0;

    public double maximumAverageSubtree(TreeNode root) {
        traverse(root);
        return res;
    }

    public int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[2];
        } else {
            int[] left = traverse(root.left);
            int[] right = traverse(root.right);
            int curSum = left[0] + right[0] + root.val;
            int cnt = left[1] + right[1] + 1;
            res = Math.max(res, (curSum + 0d) / cnt);
            return new int[] { curSum, cnt };
        }
    }
}
