package no1119;

class Solution {
    public String removeVowels(String s) {
        String str = "aeiou";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (str.indexOf(c) < 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}