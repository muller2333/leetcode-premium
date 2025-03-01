package no1586;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;


class BSTIterator {

    List<Integer> list = new ArrayList<>();
    int index = -1;

    public BSTIterator(TreeNode root) {
        traverse(root);
    }

    public void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.left);
            list.add(node.val);
            traverse(node.right);
        }
    }

    public boolean hasNext() {
        return index < list.size() - 1;
    }

    public int next() {
        return list.get(++index);
    }

    public boolean hasPrev() {
        return index > 0;
    }

    public int prev() {
        return list.get(index);
    }
}
