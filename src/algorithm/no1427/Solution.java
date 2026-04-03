package no1427;

class Solution {
    public String stringShift(String s, int[][] shift) {
        int length = s.length();
        for (int[] arr : shift) {
            int amount = arr[1] % length;
            int index = arr[0] == 0 ? amount : length - amount;
            s = s.substring(index) + s.substring(0, index);
        }
        return s;
    }
}