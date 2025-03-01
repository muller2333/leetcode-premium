package no549;

public class TreeNode {
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
    int res = 1;

    public int longestConsecutive(TreeNode root) {
        traverse(root);
        return res;
    }

    public int[] traverse(TreeNode root) {
        int[] arr = new int[2];
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            int[] lRes = traverse(left);
            int[] rRes = traverse(right);
            arr[0] = arr[1] = 1;
            if (left != null) {
                if (root.val + 1 == left.val) {
                    arr[0] = lRes[0] + 1;
                } else if (root.val == left.val + 1) {
                    arr[1] = lRes[1] + 1;
                }
            }
            if (right != null) {
                if (root.val + 1 == right.val) {
                    arr[0] = Math.max(rRes[0] + 1, arr[0]);
                } else if (root.val == right.val + 1) {
                    arr[1] = Math.max(rRes[1] + 1, arr[1]);
                }
            }
            res = Math.max(res, Math.max(arr[0], arr[1]));
            if (right != null && left != null && (root.val - left.val) * (root.val - right.val) + 1 == 0) {
                if (root.val == left.val + 1) {
                    res = Math.max(res, lRes[1] + 1 + rRes[0]);
                } else {
                    res = Math.max(res, lRes[0] + 1 + rRes[1]);
                }
            }
        }
        return arr;
    }
}
