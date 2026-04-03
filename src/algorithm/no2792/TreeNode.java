package no2792;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.TreeNode;

class Solution {
    int res = 0;

    public int countGreatEnoughNodes(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public List<Integer> traverse(TreeNode root, int k) {
        if (root == null) {
            return new ArrayList<>();
        } else {
            List<Integer> left = traverse(root.left, k);
            List<Integer> right = traverse(root.right, k);
            int size = left.size();
            int size2 = right.size();
            int i = 0;
            int j = 0;
            List<Integer> list = new ArrayList<>(size + size2 + 1);
            while (i < size && j < size2) {
                if (left.get(i) < right.get(j)) {
                    list.add(left.get(i++));
                } else {
                    list.add(right.get(j++));
                }
            }
            while (i < size) {
                list.add(left.get(i++));
            }
            while (j < size2) {
                list.add(right.get(j++));
            }
            if (size + size2 >= k && list.get(k - 1) < root.val) {
                res++;
            }
            int index = Collections.binarySearch(list, root.val);
            if (index < 0) {
                index = -index - 1;
            }
            list.add(index, root.val);
            return list;
        }
    }
}
