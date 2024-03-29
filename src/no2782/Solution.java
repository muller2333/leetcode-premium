package no2782;

interface CategoryHandler {
    // default public CategoryHandler(int[] categories);

    public boolean haveSameCategory(int a, int b);
};

class Solution {
    public int numberOfCategories(int n, CategoryHandler categoryHandler) {
        boolean[] flags = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!flags[i]) {
                res++;
                for (int j = i + 1; j < n; j++) {
                    if (categoryHandler.haveSameCategory(i, j)) {
                        flags[j] = true;
                    }
                }
            }
        }
        return res;
    }
}
