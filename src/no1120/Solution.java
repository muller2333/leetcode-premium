package no1120;

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
