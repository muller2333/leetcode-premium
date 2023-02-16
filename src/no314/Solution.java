package no314;

import java.util.*;

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
    Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        traverse(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int col : map.keySet()) {
            Map<Integer, List<Integer>> minorMap = map.get(col);
            List<Integer> li = new ArrayList<>();
            for (int row : minorMap.keySet()) {
                List<Integer> list = minorMap.get(row);
                li.addAll(list);
            }
            res.add(li);
        }
        return res;
    }

    public void traverse(TreeNode node, int col, int row) {
        if (node != null) {
            Map<Integer, List<Integer>> minorMap = map.get(col);
            if (minorMap == null) {
                minorMap = new TreeMap<>();
                map.put(col, minorMap);
            }
            if (!minorMap.containsKey(row)) {
                minorMap.put(row, new ArrayList<>());
            }
            minorMap.get(row).add(node.val);
            traverse(node.left, col - 1, row + 1);
            traverse(node.right, col + 1, row + 1);
        }
    }
}