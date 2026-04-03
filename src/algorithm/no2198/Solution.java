package no2198;

class Solution {
    public long singleDivisorTriplet(int[] nums) {
        int[] counts = new int[101];
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        for (int i = 0; i < 101; i++) {
            if (counts[i] > 0) {
                for (int j = i + 1; j < 101; j++) {
                    if (counts[j] > 0) {
                        for (int k = j + 1; k < 101; k++) {
                            if (counts[k] > 0) {
                                int sum = i + j + k;
                                int times = 0;
                                if (sum % i == 0) {
                                    times++;
                                }
                                if (sum % j == 0) {
                                    times++;
                                }
                                if (sum % k == 0) {
                                    times++;
                                }
                                if (times == 1) {
                                    System.out.println(sum);
                                    res += 6L * counts[i] * counts[j] * counts[k];
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 101; i++) {
            if (counts[i] > 0) {
                for (int j = i + 1; j < 101; j++) {
                    if (counts[j] > 0) {
                        int sum = i * 2 + j;
                        int times = 0;
                        if (sum % i == 0) {
                            times += 2;
                        }
                        if (sum % j == 0) {
                            times++;
                        }
                        if (times == 1) {
                            res += 3L * counts[i] * (counts[i] - 1L) * counts[j];
                        }
                        sum = i + j * 2;
                        times = 0;
                        if (sum % j == 0) {
                            times += 2;
                        }
                        if (sum % i == 0) {
                            times++;
                        }
                        if (times == 1) {
                            res += 3L * counts[j] * (counts[j] - 1) * counts[i];
                        }
                    }
                }
            }
        }
        return res;
    }

}