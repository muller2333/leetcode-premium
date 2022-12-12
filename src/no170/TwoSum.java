package no170;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoSum {
    List<Integer> list = new ArrayList<>();

    public TwoSum() {

    }

    public void add(int number) {
        int search = Collections.binarySearch(list, number);
        if (search < 0) {
            search = -search - 1;
        }
        list.add(search, number);
    }

    public boolean find(int value) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == value) {
                return true;
            } else if (sum < value) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}

/**
 * Your no170.TwoSum object will be instantiated and called as such:
 * no170.TwoSum obj = new no170.TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
