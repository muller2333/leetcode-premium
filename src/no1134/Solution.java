package no1134;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isArmstrong(int n) {
        List<Integer> list = new ArrayList<>();
        int temp = n;
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        long res = 0;
        int size = list.size();
        for (int digit : list) {
            int prod = 1;
            for (int i = 0; i < size; i++) {
                prod *= digit;
            }
            res += prod;
            if (res > temp) {
                return false;
            }
        }
        return res == temp;
    }
}