package no1522;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    int res = 0;

    public int diameter(Node root) {
        traverse(root);
        return res;
    }

    public int traverse(Node root) {
        if (root == null) {
            return 0;
        } else {
            List<Node> children = root.children;
            int max = 0;
            int[] arr = new int[2];
            for (Node c : children) {
                int cnt = traverse(c);
                max = Math.max(max, cnt);
                if (cnt >= arr[1]) {
                    arr[0] = arr[1];
                    arr[1] = cnt;
                } else if (cnt > arr[0]) {
                    arr[0] = cnt;
                }
            }
            res = Math.max(res, arr[0] + arr[1]);
            return max + 1;
        }

    }
}