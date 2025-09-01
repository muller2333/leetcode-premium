import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] sortByAbsoluteValue(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                map.merge(nums[i], 1, Integer::sum);
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count != null) {
                if (count == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], count - 1);
                }
                nums[i] = -nums[i];
            }
        }
        return nums;
    }
}