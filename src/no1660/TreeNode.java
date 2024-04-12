package no1660;

import java.util.Map;
import java.util.HashMap;

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