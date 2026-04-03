package no734;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int length = sentence1.length;
        int length2 = sentence2.length;
        if (length != length2) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (List<String> list : similarPairs) {
            set.add(list.get(0) + "," + list.get(1));
            set.add(list.get(1) + "," + list.get(0));
        }
        for (int i = 0; i < length; i++) {
            if (!set.contains(sentence1[i] + "," + sentence2[i]) && !set.contains(sentence2[i] + "," + sentence1[i])
                    && !sentence1[i].equals(sentence2[i])) {
                return false;
            }
        }
        return true;
    }
}
