package no1533;

interface ArrayReader {
    public int compareSub(int l, int r, int x, int y);

    public int length();
}

class Solution {
    public int getIndex(ArrayReader reader) {
        int length = reader.length();
        return getIndex(reader, 0, length);
    }

    public int getIndex(ArrayReader reader, int i, int length) {
        if (length == 1) {
            return i;
        }
        if (length == 2) {
            return reader.compareSub(i, i, i + 1, i + 1) == 1 ? i : i + 1;
        }
        int com = reader.compareSub(i, i + length / 2 - 1, i + length / 2 + (length % 2), i + length - 1);
        if (com == 0) {
            return i + length / 2;
        } else if (com == 1) {
            return getIndex(reader, i, length / 2);
        } else {
            return getIndex(reader, i + length / 2 + (length % 2), length / 2);
        }
    }
}
