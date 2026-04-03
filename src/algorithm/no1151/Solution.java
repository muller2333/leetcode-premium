package no1151;

class Solution {
    public int minSwaps(int[] data) {
        int length = data.length;
        int[] sums = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sums[i + 1] = sums[i] + data[i];
        }
        int count = sums[length];
        if (count <= 1 || count == length) {
            return 0;
        }
        int res = length;
        for (int i = count - 1; i < length; i++) {
            res = Math.min(res, count - sums[i + 1] + sums[i - count + 1]);
        }
        return res;
    }
}
