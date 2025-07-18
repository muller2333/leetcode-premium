package no302;

class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int leftX = 0;
        while (leftX < n) {
            int i = 0;
            while (i < m) {
                if (image[i][leftX] == '1') {
                    break;
                }
                i++;
            }
            if (i != m) {
                break;
            }
            leftX++;
        }
        if (leftX == n) {
            return 0;
        }
        int rightX = n - 1;
        while (rightX > leftX) {
            int i = 0;
            while (i < m) {
                if (image[i][rightX] == '1') {
                    break;
                }
                i++;
            }
            if (i != m) {
                break;
            }
            rightX--;
        }
        int topY = 0;
        while (topY < m) {
            int i = leftX;
            while (i <= rightX) {
                if (image[topY][i] == '1') {
                    break;
                }
                i++;
            }
            if (i != rightX + 1) {
                break;
            }
            topY++;
        }
        int bottomY = m - 1;
        while (bottomY > topY) {
            int i = leftX;
            while (i <= rightX) {
                if (image[bottomY][i] == '1') {
                    break;
                }
                i++;
            }
            if (i != rightX + 1) {
                break;
            }
            bottomY--;
        }
        return (rightX - leftX + 1) * (bottomY - topY + 1);
    }
}
