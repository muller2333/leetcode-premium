package no379;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class PhoneDirectory {
    List<Integer> list;
    Random r = new Random();

    public PhoneDirectory(int maxNumbers) {
        list = new ArrayList<>(maxNumbers);
        for (int i = 0; i < maxNumbers; i++) {
            list.add(i);
        }
    }

    public int get() {
        int size = list.size();
        if (size == 0) {
            return -1;
        }
        return list.remove(r.nextInt(size));
    }

    public boolean check(int number) {
        return Collections.binarySearch(list, number) >= 0;
    }

    public void release(int number) {
        int index = Collections.binarySearch(list, number);
        if (index < 0) {
            index = -index - 1;
            list.add(index, number);
        }
    }
}