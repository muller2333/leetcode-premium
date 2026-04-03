package no1826;

class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int length = sensor1.length;
        int i = 0;
        while (i < length - 1 && sensor1[i] == sensor2[i]) {
            i++;
        }
        if (i == length - 1) {
            return -1;
        } else {
            int temp = i;
            int j = i + 1;
            while (j < length && sensor1[i] == sensor2[j]) {
                i++;
                j++;
            }
            boolean flag = j == length;
            i = temp;
            j = i + 1;
            while (j < length && sensor1[j] == sensor2[i]) {
                i++;
                j++;
            }
            boolean flag2 = j == length;
            if (flag == flag2) {
                return -1;
            } else if (flag) {
                return 1;
            } else {
                return 2;
            }
        }
    }
}