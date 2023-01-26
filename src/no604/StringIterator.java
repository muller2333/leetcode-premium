package no604;

import java.util.ArrayList;
import java.util.List;

class StringIterator {
    List<Character> charList = new ArrayList<>();
    List<Integer> countList = new ArrayList<>();
    int index = 0;

    public StringIterator(String compressedString) {
        int length = compressedString.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < length) {
            char c = compressedString.charAt(i);
            if (!Character.isDigit(c)) {
                charList.add(c);
                while (++i < length) {
                    c = compressedString.charAt(i);
                    if (Character.isDigit(c)) {
                        sb.append(c);
                    } else {
                        countList.add(Integer.parseInt(sb.toString()));
                        sb = new StringBuilder();
                        break;
                    }
                }
            }
        }
        countList.add(Integer.parseInt(sb.toString()));
    }

    public char next() {
        if (index < countList.size()) {
            int val = countList.get(index);
            if (val == 0) {
                if (++index == countList.size()) {
                    return ' ';
                } else {
                    val = countList.get(index);
                }
            }
            countList.set(index, val - 1);
            return charList.get(index);
        } else {
            return ' ';
        }
    }

    public boolean hasNext() {
        return index != countList.size() && (index < countList.size() - 1 || countList.get(index) > 0);
    }

}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */