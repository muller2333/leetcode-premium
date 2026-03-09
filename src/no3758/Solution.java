package no3758;

class Solution {
    public String convertNumber(String s) {
        String[] arr = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int i = 0;
        int len = s.length();
        StringBuilder res = new StringBuilder();
        while (i < len) {
            boolean flag = false;
            for (int j = 0; j < 10; j++) {
                String str = arr[j];
                int length = str.length();
                if (i + length <= len && s.substring(i, i + length).equals(str)) {
                    i += length;
                    res.append(j);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                i++;
            }
        }
        return res.toString();
    }
}
