import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (char c : chars) {
            map.merge(c, 1, Integer::sum);
        }
        List<String> res = new ArrayList<>();
        int count = 0;
        char c = ' ';
        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                if (count++ == 1) {
                    return res;
                }
                c = key;
            }
        }
        Arrays.fill(chars, ' ');
        if (c != ' ') {
            count = map.get(c);
            if (count == 1) {
                map.remove(c);
            } else {
                map.put(c, count - 1);
            }
            chars[length / 2] = c;
        }
        getString(map, new HashMap<>(), chars, 0, res);
        return res;
    }

    public void getString(Map<Character, Integer> map, Map<Character, Integer> countMap, char[] chars, int index,
            List<String> res) {
        if (chars[index] == ' ') {
            for (char key : map.keySet()) {
                if (countMap.getOrDefault(key, 0) + 2 <= map.get(key)) {
                    chars[index] = chars[chars.length - 1 - index] = key;
                    countMap.merge(key, 2, Integer::sum);
                    getString(map, countMap, chars, index + 1, res);
                    countMap.merge(key, -2, Integer::sum);
                    chars[index] = chars[chars.length - 1 - index] = ' ';
                }
            }
        } else {
            res.add(new String(chars));
        }
    }
}