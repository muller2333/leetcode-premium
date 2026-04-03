package no2936;

abstract class BigArray {
    public BigArray(int[] elements) {
    }

    public abstract int at(long index);

    public abstract long size();
}

class Solution {
    public int countBlocks(BigArray nums) {
        long length = nums.size();
        long i = 0;
        int res = 0;
        while (i < length) {
            long left = i;
            long right = length - 1;
            int target = nums.at(i);
            while (left <= right) {
                long mid = (left + right) / 2;
                if (nums.at(mid) == target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            i = left;
            res++;
        }
        return res;
    }
}
