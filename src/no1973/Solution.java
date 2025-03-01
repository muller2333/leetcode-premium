package no1973;

import common.TreeNode;

class Solution {
    int res = 0;

    public int equalToDescendants(TreeNode root) {
        traverse(root);
        return res;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftSum = traverse(root.left);
            int rightSum = traverse(root.right);
            if (leftSum + rightSum == root.val) {
                res++;
            }
            return leftSum + rightSum + root.val;
        }
    }
}
