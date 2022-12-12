package no245;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> list = new ArrayList<>();
        int length = wordsDict.length;
        int res = length;
        if (word1.equals(word2)) {
            for (int i = 0; i < length; i++) {
                String word = wordsDict[i];
                if (word1.equals(word)) {
                    list.add(i);
                }
            }
            for (int i = 0; i < list.size() - 1; i++) {
                res = Math.min(res, list.get(i + 1) - list.get(i));
            }
        } else {
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                String word = wordsDict[i];
                if (word1.equals(word)) {
                    list.add(i);
                } else if (word2.equals(word)) {
                    list2.add(i);
                }
            }
            int size = list.size();
            int size2 = list2.size();
            if (size < size2) {
                for (int i : list) {
                    int search = -Collections.binarySearch(list2, i) - 1;
                    if (search == 0) {
                        res = Math.min(list2.get(0) - i, res);
                    } else if (search == size2) {
                        res = Math.min(i - list2.get(size2 - 1), res);
                    } else {
                        res = Math.min(Math.min(i - list2.get(search - 1), list2.get(search) - i), res);
                    }
                }
            } else {
                for (int i : list2) {
                    int search = -Collections.binarySearch(list, i) - 1;
                    if (search == 0) {
                        res = Math.min(list.get(0) - i, res);
                    } else if (search == size) {
                        res = Math.min(i - list.get(size - 1), res);
                    } else {
                        res = Math.min(Math.min(i - list.get(search - 1), list.get(search) - i), res);
                    }
                }
            }
        }
        return res;
    }
}