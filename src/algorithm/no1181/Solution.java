package no1181;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        int length = phrases.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String phrase = phrases[i];
                int index = phrase.indexOf(" ");
                String firstWord;
                String lastWord;
                Map<String, String> pair = new HashMap<>();
                Map<String, String> pair2 = new HashMap<>();
                if (index < 0) {
                    firstWord = lastWord = phrase;
                    pair.put(phrase, "");
                    pair2.put(phrase, "");
                } else {
                    firstWord = phrase.substring(0, index);
                    int idx = phrase.lastIndexOf(" ");
                    lastWord = phrase.substring(idx + 1);
                    pair.put(firstWord, phrase.substring(index));
                    pair2.put(lastWord, phrase.substring(0, idx + 1));
                }
                String phrase2 = phrases[j];
                int index2 = phrase2.indexOf(" ");
                String firstWord2;
                String lastWord2;
                Map<String, String> pair3 = new HashMap<>();
                Map<String, String> pair4 = new HashMap<>();
                if (index2 < 0) {
                    firstWord2 = lastWord2 = phrase2;
                    pair3.put(phrase2, "");
                    pair4.put(phrase2, "");
                } else {
                    firstWord2 = phrase2.substring(0, index2);
                    int idx2 = phrase2.lastIndexOf(" ");
                    lastWord2 = phrase2.substring(idx2 + 1);
                    pair3.put(firstWord2, phrase2.substring(index2));
                    pair4.put(lastWord2, phrase2.substring(0, idx2 + 1));
                }
                if (firstWord.equals(lastWord2)) {
                    String concat = pair4.get(lastWord2) + lastWord2 + pair.get(firstWord);
                    if (!res.contains(concat)) {
                        res.add(concat);
                    }
                }
                if (lastWord.equals(firstWord2)) {
                    String concat = pair2.get(lastWord) + lastWord + pair3.get(firstWord2);
                    if (!res.contains(concat)) {
                        res.add(concat);
                    }
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
