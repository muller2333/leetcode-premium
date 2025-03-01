package no663;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

class Solution {
    public boolean checkEqualTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        int sum = traverse(root, map);
        if ((sum & 1) == 0) {
            for (TreeNode node : map.keySet()) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (map.getOrDefault(right, 1_000_000_001) << 1 == sum
                        || map.getOrDefault(left, 1_000_000_001) << 1 == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    public int traverse(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        } else {
            int val = root.val + traverse(root.left, map) + traverse(root.right, map);
            map.put(root, val);
            return val;
        }
    }

}