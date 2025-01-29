package no3284;

class Solution {
    public int getSum(int[] nums) {
        long res = 0;
        int length = nums.length;
        int i = 0;
        while (i < length - 1) {
            if (Math.abs(nums[i] - nums[i + 1]) == 1) {
                int count = 2;
                i += 2;
                while (i < length) {
                    if (nums[i] + nums[i - 2] == nums[i - 1] << 1) {
                        count++;
                        i++;
                    } else {
                        break;
                    }
                }
                int j = 0;
                while (j < count) {
                    res = (res + (j + 1L) * nums[i - 1 - j] * (count - j)) % 1_000_000_007;
                    j++;
                }
                if (i != length && Math.abs(nums[i - 1] - nums[i]) == 1) {
                    if ((nums[i] - nums[i - 1]) * (nums[i - 1] - nums[i - 2]) == -1) {
                        res -= nums[--i];
                    }
                }
                if (i == length) {
                    return (int) (res % 1_000_000_007);
                }
            } else {
                res += nums[i++];
            }
        }
        return (int) ((res + nums[length - 1]) % 1_000_000_007);
    }
}