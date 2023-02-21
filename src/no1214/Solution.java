package no1214;

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
    boolean flag;

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        traverse(root1, root2, target);
        return flag;
    }

    public void traverse(TreeNode node, TreeNode root2, int target) {
        if (node != null && !flag) {
            traverse(node.left, root2, target);
            int val = node.val;
            if (flag || find(root2, target - val)) {
                flag = true;
                return;
            }
            traverse(node.right, root2, target);
        }
    }

    public boolean find(TreeNode node, int target) {
        if (node == null) {
            return false;
        } else {
            int val = node.val;
            if (val == target) {
                return true;
            } else if (val < target) {
                return find(node.right, target);
            } else {
                return find(node.left, target);
            }
        }
    }
}