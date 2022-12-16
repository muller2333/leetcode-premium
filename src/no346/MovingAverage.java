package no346;

import java.util.ArrayList;
import java.util.List;

class MovingAverage {
    int size;
    int sum = 0;
    List<Integer> list = new ArrayList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        list.add(val);
        sum += val;
        if (list.size() <= size) {
            return sum * 1d / list.size();
        } else {
            sum -= list.get(list.size() - 1 - size);
            return sum * 1d / size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */