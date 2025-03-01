package no1660;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

class Solution {
    public TreeNode correctBinaryTree(TreeNode root) {
        traverse(null, root, new HashMap<>());
        return root;
    }

    public void traverse(TreeNode parent, TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root != null) {
            if (map.containsKey(root)) {
                TreeNode invalid = map.get(root);
                parent = map.get(invalid);
                if (parent.left == invalid) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return;
            }
            map.put(root, parent);
            traverse(root, root.left, map);
            traverse(root, root.right, map);
        }
    }
}