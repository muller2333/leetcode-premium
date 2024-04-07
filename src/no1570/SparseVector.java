package no1570;

class SparseVector {
    int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;
    }

    public int dotProduct(SparseVector vec) {
        int len = nums.length;
        int[] nums2 = vec.nums;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += nums[i] * nums2[i];
        }
        return res;
    }
}