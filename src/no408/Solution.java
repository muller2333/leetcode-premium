package no408;

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int length = abbr.length();
        while (i < length) {
            char c = abbr.charAt(i);
            if (c >= '0' && c <= '9') {
                StringBuilder countStr = new StringBuilder();
                while (i < length) {
                    c = abbr.charAt(i);
                    if (c <= '9' && c >= '0') {
                        countStr.append(c);
                        i++;
                    } else {
                        if (countStr.charAt(0) == '0') {
                            return false;
                        } else {
                            int count = Integer.parseInt(countStr.toString());
                            if (count > 19) {
                                return false;
                            } else {
                                while (count > 0) {
                                    sb.append('A');
                                    count--;
                                }
                                break;
                            }
                        }
                    }
                }
                if (i == length) {
                    if (countStr.charAt(0) == '0') {
                        return false;
                    } else {
                        int count = Integer.parseInt(countStr.toString());
                        if (count > 19) {
                            return false;
                        } else {
                            while (count > 0) {
                                sb.append('A');
                                count--;
                            }
                        }
                    }
                }
            } else {
                sb.append(c);
                i++;
            }
        }
        int len = word.length();
        if (sb.length() != len) {
            return false;
        }
        for (int j = 0; j < len; j++) {
            char c = sb.charAt(j);
            if (c != 'A' && c != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

//    public boolean validWordAbbreviation(String word, String abbr) {
//        int i = 0;
//        StringBuilder sb = new StringBuilder();
//        abbr += "a";
//        int length = abbr.length();
//        while (i < length) {
//            char c = abbr.charAt(i);
//            if (c >= '0' && c <= '9') {
//                StringBuilder countStr = new StringBuilder();
//                while (i < length) {
//                    c = abbr.charAt(i);
//                    if (c <= '9' && c >= '0') {
//                        countStr.append(c);
//                        i++;
//                    } else {
//                        if (countStr.charAt(0) == '0') {
//                            return false;
//                        } else {
//                            int count = Integer.parseInt(countStr.toString());
//                            if (count > 19) {
//                                return false;
//                            } else {
//                                while (count > 0) {
//                                    sb.append('A');
//                                    count--;
//                                }
//                                break;
//                            }
//                        }
//                    }
//                }
//            } else {
//                sb.append(c);
//                i++;
//            }
//        }
//        int len = word.length();
//        if (sb.length() != len + 1) {
//            return false;
//        }
//        for (int j = 0; j < len; j++) {
//            char c = sb.charAt(j);
//            if (c != 'A' && c != word.charAt(j)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
