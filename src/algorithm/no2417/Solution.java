package no2417;

class Solution {
    public int decrease(int n, int original, int diff) {
        int temp = n;
        int mul = 1;
        while (temp > 0) {
            int rem = temp % 10;
            if (temp % 2 == diff) {
                if (n - rem * mul > original) {
                    n -= (rem - diff) * mul;
                } else {
                    break;
                }
            }
            temp /= 10;
            mul *= 10;
        }
        return n;
    }

    public int closestFair(int n) {
        int length = (n + "").length();
        if (length % 2 == 1) {
            int res = 1;
            length = (length + 1) / 2;
            for (int i = 0; i < length; i++) {
                res *= 10;
            }
            length--;
            for (int i = 0; i < length; i++) {
                res = res * 10 + 1;
            }
            return res;
        }
        int count = 0;
        int temp = n;
        int[] arr = new int[length];
        int idx = length;
        while (temp > 0) {
            int rem = temp % 10;
            if (rem % 2 == 1) {
                count++;
            } else {
                count--;
            }
            arr[--idx] = rem;
            temp /= 10;
        }
        if (count == 0) {
            return n;
        } else {
            idx = length - 1;
            int diff = count > 0 ? 0 : 1;
            while (arr[idx] % 2 == diff) {
                idx--;
            }
            arr[idx] = (arr[idx] + 1) % 10;
            if (diff == 0 && arr[idx--] == 0) {
                while (idx >= 0 && arr[idx] == 9) {
                    arr[idx--] = 0;
                }
                if (idx == -1) {
                    arr = new int[length + 1];
                    arr[0] = 1;
                } else {
                    arr[idx]++;
                }
            }
            int res = 0;
            for (int i : arr) {
                res = res * 10 + i;
            }
            return decrease(closestFair(res), n, diff);
        }
    }
}
