package no1740;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        if (p == q) {
            return 0;
        }
        Map<Integer, String> map = new HashMap<>();
        traverse(root, "", map, p, q);
        String s = map.get(p);
        String s2 = map.get(q);
        int length = s.length();
        int length2 = s2.length();
        int limit = Math.min(length, length2);
        int i = 0;
        while (i < limit && s.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return length + length2 - i * 2;
    }

    public void traverse(TreeNode node, String path, Map<Integer, String> map, int p, int q) {
        if (node != null && map.size() < 2) {
            if (node.val == p || node.val == q) {
                map.put(node.val, path);
            }
            traverse(node.left, path + "0", map, p, q);
            traverse(node.right, path + "1", map, p, q);
        }
    }
}