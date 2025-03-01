package no742;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

class Solution {

    boolean flag = false;
    String target = "";

    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer, String> map = new HashMap<>();
        traverse(root, "", k, map);
        int res = k;
        int dist = 1000;
        if (!flag) {
            int length = target.length();
            for (int key : map.keySet()) {
                String str = map.get(key);
                int len = str.length();
                int limit = Math.min(length, len);
                int i = 0;
                for (; i < limit; i++) {
                    if (target.charAt(i) != str.charAt(i)) {
                        break;
                    }
                }
                int sum = length + len - 2 * i;
                if (sum < dist) {
                    dist = sum;
                    res = key;
                }
            }
        }
        return res;
    }

    public void traverse(TreeNode root, String s, int k, Map<Integer, String> map) {
        if (root != null) {
            if (root.val == k) {
                target = s;
            }
            if (root.left == null && root.right == null) {
                if (root.val == k) {
                    flag = true;
                } else {
                    map.put(root.val, s);
                }
            } else {
                traverse(root.left, s + "0", k, map);
                traverse(root.right, s + "1", k, map);
            }
        }
    }
}
