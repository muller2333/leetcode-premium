package no366;

import java.util.ArrayList;
import java.util.List;

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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        while (root.left != null || root.right != null) {
            traverse(root);
            List<Integer> list = new ArrayList<>();
            traverse(root, list);
            res.add(list);
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        res.add(list);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                root.val += 300;
            }
            traverse(root.left);
            traverse(root.right);
        }
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null && left.val >= 200) {
                root.left = null;
                list.add(left.val - 300);
            }
            if (right != null && right.val >= 200) {
                root.right = null;
                list.add(right.val - 300);
            }
            traverse(root.left, list);
            traverse(root.right, list);
        }

    }
}