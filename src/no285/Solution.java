package no285;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    TreeNode res;
    boolean found;
    boolean flag;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root != null) {
            inorderSuccessor(root.left, p);
            if (root == p) {
                found = true;
            } else if (found) {
                if (!flag) {
                    flag = true;
                    res = root;
                }
            }
            inorderSuccessor(root.right, p);
        }
        return res;
    }

}

//class Solution {
//
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        List<TreeNode> list = new ArrayList<>();
//        traverse(root, list);
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//            if (p == list.get(i)) {
//                return i == size - 1 ? null : list.get(i + 1);
//            }
//        }
//        return null;
//    }
//
//    public void traverse(TreeNode node, List<TreeNode> list) {
//        if (node != null) {
//            traverse(node.left, list);
//            list.add(node);
//            traverse(node.right, list);
//        }
//    }
//
//}