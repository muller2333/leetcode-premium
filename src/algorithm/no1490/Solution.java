package no1490;

import java.util.ArrayList;
import java.util.List;

import common.Node;

class Solution {
    public Node cloneTree(Node root) {
        if (root != null) {
            Node copyNode = new Node(root.val);
            List<Node> children = root.children;
            if (children != null) {
                List<Node> copyChildren = new ArrayList<>();
                for (Node node : children) {
                    copyChildren.add(cloneTree(node));
                }
                copyNode.children = copyChildren;
            }
            return copyNode;
        } else {
            return null;
        }
    }
}