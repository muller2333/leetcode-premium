package no333;

import common.TreeNode;

class Solution {
    int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        traverse(root);
        return res;
    }

    public int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0, 0 };
        } else {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null && right == null) {
                int[] arr = traverse(left);
                if (arr[2] < root.val) {
                    res = Math.max(res, arr[0] + 1);
                    return new int[] { arr[0] + 1, arr[1], root.val };
                } else {
                    return new int[] { 0, -10_000, 10_000 };
                }
            } else if (left == null && right != null) {
                int[] arr = traverse(right);
                if (arr[1] > root.val) {
                    res = Math.max(res, arr[0] + 1);
                    return new int[] { arr[0] + 1, root.val, arr[2] };
                } else {
                    return new int[] { 0, -10_000, 10_000 };
                }
            } else if (left == null && right == null) {
                res = Math.max(res, 1);
                return new int[] { 1, root.val, root.val };
            } else {
                int[] lArr = traverse(left);
                int[] rArr = traverse(right);
                if (lArr[2] < root.val && rArr[1] > root.val) {
                    res = Math.max(res, lArr[0] + rArr[0] + 1);
                    return new int[] { lArr[0] + rArr[0] + 1, lArr[1], rArr[2] };
                } else {
                    return new int[] { 0, -10_000, 10_000 };
                }
            }
        }
    }
}