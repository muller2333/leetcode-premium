package no3831;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.TreeNode;

class Solution {
    public int levelMedian(TreeNode root, int level) {
        if (level == 0) {
            return root.val;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int lv = 1;
        while (list.size() != 0) {
            List<TreeNode> mid = new ArrayList<>();
            for (TreeNode node : list) {
                TreeNode left = node.left;
                if (left != null) {
                    mid.add(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    mid.add(right);
                }
            }
            if (level == lv && mid.size() > 0) {
                Collections.sort(mid, (a, b) -> a.val - b.val);
                return mid.get(mid.size() / 2).val;
            }
            lv++;
            list = mid;
        }
        return -1;
    }

}