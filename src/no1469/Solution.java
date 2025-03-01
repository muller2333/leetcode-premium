package no1469;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode node) {
        if (node != null) {
            if (node.left != null && node.right == null) {
                res.add(node.left.val);
                traverse(node.left);
            } else if (node.left == null && node.right != null) {
                res.add(node.right.val);
                traverse(node.right);
            } else if (node.left != null && node.right != null) {
                traverse(node.left);
                traverse(node.right);
            }
        }
    }
}