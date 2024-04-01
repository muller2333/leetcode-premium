package no1063;

class Solution {
    public int validSubarrays(int[] nums) {
        int length = nums.length;
        long res = 0;
        int after = -1;
        int min = 100_001;
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                res += length - i;
                count++;
            } else {
                if (nums[i] <= after) {
                    int j = i + count + 1;
                    int cnt = count++;
                    for (; j < length; j++) {
                        if (nums[j] >= nums[i]) {
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    res += ++cnt;
                } else {
                    res++;
                    count = 1;
                }
            }
            min = Math.min(min, nums[i]);
            after = nums[i];
        }
        return (int) res;
    }
}