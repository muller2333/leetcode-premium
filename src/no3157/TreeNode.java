package no3157;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

class Solution {
    public int minimumLevel(TreeNode root) {
        Map<Integer, Long> map = new HashMap<>();
        traverse(root, 1, map);
        long min = Long.MAX_VALUE;
        int res = 100_000;
        for (int key : map.keySet()) {
            long val = map.get(key);
            if (val < min) {
                min = val;
                res = key;
            } else if (val == min) {
                res = Math.min(res, key);
            }
        }
        return res;
    }

    public void traverse(TreeNode root, int level, Map<Integer, Long> map) {
        if (root != null) {
            map.merge(level, root.val + 0L, Long::sum);
            traverse(root.left, level + 1, map);
            traverse(root.right, level + 1, map);
        }
    }
}
