public class BigIntAdder {

    /**
     * 两个字符串相加
     * 
     * @param num1 第一个大整数字符串
     * @param num2 第二个大整数字符串
     * @return 和的字符串表示
     */
    public static String addStrings(String num1, String num2) {
        char[] chars = num1.toCharArray();
        char[] chs = num2.toCharArray();
        int i = chars.length, j = chs.length;
        // 预分配
        StringBuilder res = new StringBuilder(Math.max(i--, j--) + 1);
        for (int c = 0; i >= 0 || j >= 0 || c > 0; i--, j--) {
            int a = i < 0 ? 0 : chars[i] - '0';
            int b = j < 0 ? 0 : chs[j] - '0';
            c += a + b;
            res.append(c % 10);
            c /= 10;
        }
        return res.reverse().toString();
    }
}