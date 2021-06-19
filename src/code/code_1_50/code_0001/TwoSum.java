package code.code_1_50.code_0001;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }

        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = cache.get(target - nums[i]);
            if (index != null) {
                result[0] = index;
                result[1] = i;
                break;
            }

            cache.put(nums[i], i);
        }

        return result;
    }
}
