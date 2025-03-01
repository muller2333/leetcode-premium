package no272;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.TreeNode;

class Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Double> list = new ArrayList<>();
        traverse(root, list);
        int index = Collections.binarySearch(list, target);
        List<Integer> res = new ArrayList<>();
        int size = list.size();
        int j;
        if (index < 0) {
            index = -index - 1;
            j = index;
        } else {
            res.add(list.get(index).intValue());
            k--;
            j = index + 1;
        }
        int i = index - 1;
        while (i >= 0 && j < size && k > 0) {
            if (list.get(j) - target > target - list.get(i)) {
                res.add(list.get(i--).intValue());
            } else {
                res.add(list.get(j++).intValue());
            }
            k--;
        }
        while (i >= 0 && k > 0) {
            res.add(list.get(i--).intValue());
            k--;
        }
        while (j < size && k > 0) {
            res.add(list.get(j++).intValue());
            k--;
        }
        return res;
    }

    public void traverse(TreeNode root, List<Double> list) {
        if (root != null) {
            traverse(root.left, list);
            list.add(0d + root.val);
            traverse(root.right, list);
        }
    }
}
