package no2689;

class RopeTreeNode {
    int len;
    String val;
    RopeTreeNode left;
    RopeTreeNode right;

    RopeTreeNode() {
    }

    RopeTreeNode(String val) {
        this.len = 0;
        this.val = val;
    }

    RopeTreeNode(int len) {
        this.len = len;
        this.val = "";
    }

    RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
        this.len = len;
        this.val = "";
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public char getKthCharacter(RopeTreeNode root, int k) {
        StringBuilder res = new StringBuilder();
        traverse(root, res, k);
        return res.charAt(k - 1);
    }

    public void traverse(RopeTreeNode rtn, StringBuilder res, int k) {
        if (rtn != null) {
            if (rtn.len > 0) {
                traverse(rtn.left, res, k);
                traverse(rtn.right, res, k);
            } else {
                res.append(rtn.val);
                if (res.length() >= k) {
                    return;
                }
            }
        }
    }
}
