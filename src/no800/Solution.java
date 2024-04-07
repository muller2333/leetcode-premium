package no800;

class Solution {
    public String similarRGB(String color) {
        char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] chars = color.toCharArray();
        for (int i = 1; i < 7; i += 2) {
            int min = 256;
            int first = chars[i] <= '9' ? chars[i] - '0' : chars[i] - 'a' + 10;
            int second = chars[i + 1] <= '9' ? chars[i + 1] - '0' : chars[i + 1] - 'a' + 10;
            for (int j = 0; j < 16; j++) {
                int diff = 17 * j - (16 * first + second);
                if (Math.abs(diff) < min) {
                    min = Math.abs(diff);
                    chars[i] = chars[i + 1] = chs[j];
                }
            }
        }
        return new String(chars);
    }
}
