package no1973;

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
