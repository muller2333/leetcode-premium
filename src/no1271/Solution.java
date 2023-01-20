package no1271;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String toHexspeak(String num) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');
        map.put(0, 'O');
        map.put(1, 'I');
        long n = Long.parseLong(num);
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            Character character = map.get((int) (n % 16));
            if (character == null) {
                return "ERROR";
            } else {
                sb.append(character);
            }
            n >>= 4;
        }
        return sb.reverse().toString();
    }
}
