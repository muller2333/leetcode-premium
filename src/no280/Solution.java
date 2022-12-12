package no280;

import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] arr = new int[len];
        int index = 0;
        for (int i = 0; i < len; i += 2) {
            arr[i] = nums[index++];
        }
        for (int i = 1; i < len; i += 2) {
            arr[i] = nums[index++];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = arr[i];
        }
    }
}