package no536;

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
    public TreeNode str2tree(String s) {
        if (s.equals("")) {
            return null;
        }
        int index = s.indexOf("(");
        if (index < 0) {
            int rootVal = Integer.parseInt(s);
            return new TreeNode(rootVal);
        }
        int rootVal = Integer.parseInt(s.substring(0, index));
        TreeNode root = new TreeNode(rootVal);
        int i = index + 1;
        int count = 1;
        while (count > 0) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            i++;
        }
        String left = s.substring(index + 1, i - 1);
        root.left = str2tree(left);
        if (i != s.length()) {
            root.right = str2tree(s.substring(i + 1, s.length() - 1));
        }
        return root;
    }
}