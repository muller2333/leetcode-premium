package no3437;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[][] permute(int n) {
        if (n == 1) {
            int[][] arr = new int[1][1];
            arr[0][0] = 1;
            return arr;
        }
        int[] evens = new int[n >> 1];
        int evenSum = 0;
        int oddSum = 0;
        int[] odds = new int[(n + 1) >> 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                evens[i / 2 - 1] = i;
                evenSum += i;
            } else {
                odds[i / 2] = i;
                oddSum += i;
            }
        }
        List<List<Integer>> evenList = new ArrayList<>();
        for (int i : evens) {
            List<Integer> li = new ArrayList<>();
            li.add(i);
            evenList.add(li);
        }
        int size = 1;
        int length = evens.length;
        while (size < length - 1) {
            List<List<Integer>> mid = new ArrayList<>();
            for (List<Integer> li : evenList) {
                Set<Integer> set = new HashSet<>();
                for (int i : evens) {
                    set.add(i);
                }
                for (int i : li) {
                    set.remove(i);
                }
                for (int i : set) {
                    List<Integer> midList = new ArrayList<>();
                    for (int j : li) {
                        midList.add(j);
                    }
                    midList.add(i);
                    mid.add(midList);
                }
            }
            evenList = mid;
            size++;
        }
        if (length != 1) {
            for (List<Integer> li : evenList) {
                int sum = 0;
                for (int i : li) {
                    sum += i;
                }
                li.add(evenSum - sum);
            }
        }
        List<List<Integer>> oddList = new ArrayList<>();
        for (int i : odds) {
            List<Integer> li = new ArrayList<>();
            li.add(i);
            oddList.add(li);
        }
        size = 1;
        length = odds.length;
        while (size < length - 1) {
            List<List<Integer>> mid = new ArrayList<>();
            for (List<Integer> li : oddList) {
                Set<Integer> set = new HashSet<>();
                for (int i : odds) {
                    set.add(i);
                }
                for (int i : li) {
                    set.remove(i);
                }
                for (int i : set) {
                    List<Integer> midList = new ArrayList<>();
                    for (int j : li) {
                        midList.add(j);
                    }
                    midList.add(i);
                    mid.add(midList);
                }
            }
            oddList = mid;
            size++;
        }
        if (length != 1) {
            for (List<Integer> li : oddList) {
                int sum = 0;
                for (int i : li) {
                    sum += i;
                }
                li.add(oddSum - sum);
            }
        }
        int evenSize = evenList.size();
        int oddSize = oddList.size();
        String[] arr;
        if (n % 2 == 0) {
            arr = new String[evenSize * oddSize * 2];
            int idx = 0;
            for (int i = 0; i < oddSize; i++) {
                for (int j = 0; j < evenSize; j++) {
                    int m = 0;
                    int k = 0;
                    StringBuilder sb = new StringBuilder();
                    while (m < odds.length && k < evens.length) {
                        sb.append((char) (oddList.get(i).get(m++) + 'a'));
                        sb.append((char) (evenList.get(j).get(k++) + 'a'));
                    }
                    arr[idx++] = sb.toString();
                }
            }
            for (int i = 0; i < evenSize; i++) {
                for (int j = 0; j < oddSize; j++) {
                    int m = 0;
                    int k = 0;
                    StringBuilder sb = new StringBuilder();
                    while (m < evens.length && k < odds.length) {
                        sb.append((char) (evenList.get(i).get(m++) + 'a'));
                        sb.append((char) (oddList.get(j).get(k++) + 'a'));
                    }
                    arr[idx++] = sb.toString();
                }
            }
        } else {
            arr = new String[evenSize * oddSize];
            int idx = 0;
            for (int i = 0; i < oddSize; i++) {
                for (int j = 0; j < evenSize; j++) {
                    int m = 0;
                    int k = 0;
                    StringBuilder sb = new StringBuilder();
                    while (m < odds.length && k < evens.length) {
                        sb.append((char) (oddList.get(i).get(m++) + 'a'));
                        sb.append((char) (evenList.get(j).get(k++) + 'a'));
                    }
                    sb.append((char) (oddList.get(i).get(m++) + 'a'));
                    arr[idx++] = sb.toString();
                }
            }
        }
        Arrays.sort(arr);
        length = arr.length;
        int len = arr[0].length();
        int[][] res = new int[length][len];
        for (int i = 0; i < arr.length; i++) {
            res[i] = new int[len];
            for (int j = 0; j < len; j++) {
                res[i][j] = arr[i].charAt(j) - 'a';
            }
        }
        return res;
    }
}