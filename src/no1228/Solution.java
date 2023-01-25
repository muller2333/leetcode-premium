package no1228;

class Solution {
    public int missingNumber(int[] arr) {
        if (arr[0] == arr[1]) {
            return arr[0];
        }
        for (int i = 0; i < arr.length - 2; i++) {
            int diff = arr[i] - arr[i + 1];
            int diff2 = arr[i + 1] - arr[i + 2];
            if (diff2 == diff << 1) {
                return (arr[i + 1] + arr[i + 2]) >> 1;
            } else if (diff == diff2 << 1) {
                return (arr[i + 1] + arr[i]) >> 1;
            }
        }
        return 0;
    }
}