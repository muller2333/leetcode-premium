import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    /**
     * 识别有效括号
     * 有效字符串需满足：
     * 1. 左括号必须用相同类型的右括号闭合。
     * 2. 左括号必须以正确的顺序闭合。
     * 3. 每个右括号都有一个对应的相同类型的左括号。
     * 
     * @param s 只包含括号字符的字符串
     * @return 如果字符串是有效的括号序列返回 true，否则返回 false
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) { // s 长度必须是偶数
            return false;
        }
        // 预处理
        Map<Character, Character> map = new HashMap<>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) { // c 是左括号
                queue.push(c); // 入栈
            } else if (queue.isEmpty() || queue.pop() != map.get(c)) { // c 是右括号
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return queue.isEmpty(); // 所有左括号必须匹配完毕

    }
}
