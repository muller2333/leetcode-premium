package no1133;

class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] arr = new int[1001];
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 1000; i >= 0; i--) {
            if (arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}