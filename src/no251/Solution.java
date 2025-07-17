package no251;

class Vector2D {
    int m = 0;
    int n = 0;
    int[][] vec;

    public Vector2D(int[][] vec) {
        this.vec = vec;
    }

    public int next() {
        if (n == vec[m].length) {
            n = 0;
            m++;
        }
        return vec[m][n++];
    }

    public boolean hasNext() {
        while (m != vec.length && n == vec[m].length) {
            n = 0;
            m++;
        }
        return m != vec.length;
    }
}