package no1118;

class Solution {
    public int numberOfDays(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                return 29;
            } else {
                return 28;
            }
//            if (year % 4 != 0 || (year % 400 != 0 && year % 100 == 0)) {
//                return 28;
//            } else {
//                return 29;
//            }
        }
    }
}