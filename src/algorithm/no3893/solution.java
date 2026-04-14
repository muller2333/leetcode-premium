package no3893;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maximumTeamSize(int[] startTime, int[] endTime) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        final int length = startTime.length;
        for (int i = 0; i < length; i++) {
            start.add(startTime[i]);
            end.add(endTime[i]);
        }
        Collections.sort(start);
        Collections.sort(end);
        int res = 0;
        for (int i = 0; i < length; i++) {
            int target = endTime[i] + 1;
            int idx = Collections.binarySearch(start, target);
            int count;
            if (idx < 0) {
                count = length + idx + 1;
            } else {
                int left = 0;
                int right = idx;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (start.get(mid) == target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                count = length - left;
            }
            if (length - count > res) {
                target = startTime[i] - 1;
                idx = Collections.binarySearch(end, target);
                if (idx < 0) {
                    count -= idx + 1;
                } else {
                    int left = idx;
                    int right = length - 1;
                    while (left <= right) {
                        int mid = (left + right) >> 1;
                        if (end.get(mid) == target) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    count += right + 1;
                }
                res = Math.max(res, length - count);
            }
        }
        return res;
    }
}
