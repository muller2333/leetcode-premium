package no604.another;

class StringIterator {
    int index = 0;
    String s;
    int length;
    char c;
    int count;

    public StringIterator(String compressedString) {
        this.s = compressedString;
        this.length = s.length();
        this.c = s.charAt(index++);
        int cnt = 0;
        int num;
        while (index < length && (num = s.charAt(index) - '0') >= 0 && num <= 9) {
            cnt = cnt * 10 + num;
            index++;
        }
        this.count = cnt;
    }

    public char next() {
        if (count > 0) {
            count--;
            return c;
        } else {
            if (index == length) {
                return ' ';
            }
            c = s.charAt(index++);
            int cnt = 0;
            int num;
            while (index < length && (num = s.charAt(index) - '0') >= 0 && num <= 9) {
                cnt = cnt * 10 + num;
                index++;
            }
            this.count = cnt - 1;
            return c;
        }
    }

    public boolean hasNext() {
        return count > 0 || index != length;
    }

}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */