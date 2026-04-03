package no1676;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    Map<Integer, String> map = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        int len = nodes.length;
        if (len == 1) {
            return nodes[0];
        } else {
            traverse(root, "");
            String s = map.get(nodes[0].val);
            String s2 = map.get(nodes[1].val);
            StringBuilder sb = new StringBuilder();
            int limit = Math.min(s.length(), s2.length());
            for (int i = 0; i < limit; i++) {
                char c = s.charAt(i);
                if (c == s2.charAt(i)) {
                    sb.append(c);
                } else {
                    break;
                }
            }
            for (int i = 2; i < len; i++) {
                s = sb.toString();
                s2 = map.get(nodes[i].val);
                sb = new StringBuilder();
                limit = Math.min(s.length(), s2.length());
                for (int j = 0; j < limit; j++) {
                    char c = s.charAt(j);
                    if (c == s2.charAt(j)) {
                        sb.append(c);
                    } else {
                        break;
                    }
                }
                if ("".equals(sb.toString())) {
                    return root;
                }
            }
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return root;
        }
    }

    public void traverse(TreeNode node, String path) {
        if (node != null) {
            map.put(node.val, path);
            traverse(node.left, path + "0");
            traverse(node.right, path + "1");
        }
    }
}