package no255;

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder, 0, preorder.length);
    }

    public boolean verifyPreorder(int[] preorder, int i, int j) {
        int length = j - i;
        if (length <= 1) {
            return true;
        }
        if (preorder[i + 1] == preorder[i]) {
            return false;
        } else if (preorder[i + 1] > preorder[i]) {
            for (int m = i + 2; m < j; m++) {
                if (preorder[m] <= preorder[i]) {
                    return false;
                }
            }
            return verifyPreorder(preorder, i + 1, j);
        }
        int k = i + 1;
        while (k < j && preorder[k] < preorder[i]) {
            k++;
        }
        for (int m = k; m < j; m++) {
            if (preorder[m] <= preorder[i]) {
                return false;
            }
        }
        return verifyPreorder(preorder, i + 1, k) && verifyPreorder(preorder, k, j);
    }
}