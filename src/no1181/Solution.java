package no1181;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, List<String>> map = new HashMap<>();
        final String str = " ";
        for (String phrase : phrases) {
            int index = phrase.indexOf(str);
            int lastIndex = phrase.lastIndexOf(str);
            String firstWord = phrase.substring(0, index);
            String lastWord = phrase.substring(lastIndex + 1);
        }
        return null;
    }
}