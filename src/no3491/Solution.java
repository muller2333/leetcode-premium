package no3491;

class Solution {
    public boolean phonePrefix(String[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && (numbers[i].startsWith(numbers[j]) || numbers[j].startsWith(numbers[i]))) {
                    return false;
                }
            }
        }
        return true;
    }
}