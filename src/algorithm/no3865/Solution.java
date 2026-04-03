class Solution {
    public int[] reverseSubarrays(int[] nums, int k) {
        int length = nums.length;
        int width = length / k;
        for (int i = 0; i < length; i += width) {
            int left = i;
            int right = left + width - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }
        return nums;
    }
}