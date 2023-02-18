package no1602;

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

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        while ((size = queue.size()) > 0) {
            Queue<TreeNode> mid = new LinkedList<>();
            boolean found = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == u) {
                    return i == size - 1 ? null : queue.poll();
                } else {
                    TreeNode left = node.left;
                    if (left != null) {
                        if (found) {
                            return left;
                        } else {
                            if (left == u) {
                                found = true;
                            } else {
                                TreeNode left2 = left.left;
                                if (left2 != null) {
                                    mid.add(left2);
                                }
                                TreeNode right2 = left.right;
                                if (right2 != null) {
                                    mid.add(right2);
                                }
                            }
                        }
                        queue.add(left);
                    }
                    TreeNode right = node.right;
                    if (right != null) {
                        if (found) {
                            return right;
                        } else {
                            if (right == u) {
                                found = true;
                            } else {
                                TreeNode left2 = right.left;
                                if (left2 != null) {
                                    mid.add(left2);
                                }
                                TreeNode right2 = right.right;
                                if (right2 != null) {
                                    mid.add(right2);
                                }
                            }
                        }
                        queue.add(right);
                    }
                }
            }
            if (found) {
                return null;
            } else {
                queue = mid;
            }
        }
        return null;
    }

}