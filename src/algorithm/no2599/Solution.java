package no2599;

import java.util.PriorityQueue;

class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        int res = 0;
        int length = nums.length;
        int i = 0;
        while (i < length && nums[i] < 0) {
            i++;
            res++;
        }
        long sum = nums[i];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(nums[i++]);
        while (i < length) {
            if ((sum += nums[i]) < 0) {
                res++;
                if (nums[i] > q.peek()) {
                    sum -= q.poll();
                    q.add(nums[i]);
                } else {
                    sum -= nums[i];
                }
            } else if (nums[i] < 0) {
                q.add(nums[i]);
            }
            i++;
        }
        return res;
    }
}