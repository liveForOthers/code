package code.code_201_250.code_217;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /*
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the array,
     * and it should return false if every element is distinct.
     * 给定整数数组，找出数组中是否有重复元素
     * 如有返回true  否则返回false
     * Example 1:
     *
     * Input: [1,2,3,1]
     * Output: true
     *
     * Example 2:
     * Input: [1,2,3,4]
     * Output: false
     *
     * Example 3:
     * Input: [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     * 算法：
     * 使用set缓存 如set中不存在 加入set  否则返回true
     * */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> cache = new HashSet<>(nums.length);
        for (int cur : nums) {
            if (cache.contains(cur)) {
                return true;
            }
            cache.add(cur);
        }
        return false;
    }
}
