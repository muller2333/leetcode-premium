package no1506;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import common.Node;

class Solution {
    public Node findRoot(List<Node> tree) {
        Set<Integer> set = new HashSet<>();
        for (Node node : tree) {
            for (Node nd : node.children) {
                set.add(nd.val);
            }
        }
        for (Node node : tree) {
            if (!set.contains(node.val)) {
                return node;
            }
        }
        return null;
    }
}
