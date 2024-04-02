package no1644;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<String> list = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p.val, q.val, "");
        if (list.size() < 2) {
            return null;
        }
        String res = list.get(0);
        String res2 = list.get(1);
        int size = Math.min(res.length(), res2.length());
        for (int i = 0; i < size; i++) {
            char c = res.charAt(i);
            if (c != res2.charAt(i)) {
                break;
            } else {
                if (c == '0') {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }
        return root;
    }

    public void traverse(TreeNode node, int p, int q, String s) {
        if (node != null) {
            int val = node.val;
            if (val == p || val == q) {
                list.add(s);
                if (list.size() == 2) {
                    return;
                }
            }
            traverse(node.left, p, q, s + "0");
            traverse(node.right, p, q, s + "1");
        }
    }
}
