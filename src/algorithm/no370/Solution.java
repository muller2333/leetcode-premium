package no370;

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int[] update = updates[i];
            for (int j = update[0]; j <= update[1]; j++) {
                res[j] += update[2];
            }
        }
        return res;
    }
}