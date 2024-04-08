package no2340;

class Solution {
    public int minimumSwaps(int[] nums) {
        int res = 0;
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        int length = nums.length;
        int i = length - 1;
        while (nums[i] != max) {
            i--;
        }
        while (i < length - 1) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
            res++;
            i++;
        }
        int min = 100_001;
        for (int j : nums) {
            min = Math.min(min, j);
        }
        i = 0;
        while (nums[i] != min) {
            i++;
        }
        return res + i;
    }
}
