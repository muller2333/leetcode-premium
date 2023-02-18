package no702;

interface ArrayReader {
    public int get(int index);
}

class Solution {
    public int search(ArrayReader reader, int target) {
        int i = 1;
        int j = 10_000;
        int mid;
        while (i <= j) {
            mid = (i + j) >> 1;
            if (reader.get(mid - 1) == Integer.MAX_VALUE) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        i = 0;
        j--;
        while (i <= j) {
            mid = (i + j) >> 1;
            int num = reader.get(mid);
            if (num == target) {
                return mid;
            } else if (num < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}