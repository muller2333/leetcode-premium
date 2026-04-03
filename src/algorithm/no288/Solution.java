package no288;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

class ValidWordAbbr {
    Map<String, Set<String>> map = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            int length = word.length();
            String abbr = word;
            if (length > 2) {
                abbr = "" + word.charAt(0) + (length - 2) + word.charAt(length - 1);
            }
            map.putIfAbsent(abbr, new HashSet<>());
            map.get(abbr).add(word);
        }
    }

    public boolean isUnique(String word) {
        int length = word.length();
        String abbr = word;
        if (length > 2) {
            abbr = "" + word.charAt(0) + (length - 2) + word.charAt(length - 1);
        }
        Set<String> set = map.get(abbr);
        if (set == null || (set.size() == 1 && set.contains(word))) {
            return true;
        }
        return false;
    }
}
