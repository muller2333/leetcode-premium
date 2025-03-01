package no270;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.TreeNode;

class Solution {
    List<Double> list = new ArrayList<>();

    public int closestValue(TreeNode root, double target) {
        traverse(root);
        if (list.get(0) >= target) {
            return list.get(0).intValue();
        }
        if (list.get(list.size() - 1) <= target) {
            return list.get(list.size() - 1).intValue();
        }
        int search = Collections.binarySearch(list, target);
        if (search >= 0) {
            return list.get(search).intValue();
        } else {
            search = -search - 1;
            return list.get(search) + list.get(search - 1) < target * 2 ? list.get(search).intValue()
                    : list.get(search - 1).intValue();
        }
    }

    public void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            list.add((double) root.val);
            traverse(root.right);
        }
    }
}