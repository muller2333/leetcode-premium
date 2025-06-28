package no1428;

import java.util.List;

interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
};

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);
        int res = cols;
        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = cols - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (binaryMatrix.get(i, mid) == 1) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res = Math.min(res, left);
        }
        return res == cols ? -1 : res;
    }
}
