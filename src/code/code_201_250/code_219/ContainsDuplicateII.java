package code.code_201_250.code_219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {

    /*
     * Given an array of integers and an integer k,
     * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
     * and the absolute difference between i and j is at most k.
     * 给定整数数组 和 一个整数k,找出是否这里有两个不重复的索引i,j 满足两个元素相等
     * 并且索引差值绝对值最大为k
     * Example 1:
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     *
     * Example 2:
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     *
     * Example 3:
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     *
     * 算法：
     * 使用map进行缓存  key为整数值  value为最大的索引位置
     * 遍历数组
     * 如当前元素在map中
     * 1 存在：判断索引是否满足要求  cur-value<=k
     *   1.1 满足   返回true
     *   1.2 不满足 更新value为当前索引
     * 2 不存在 加入到map中
     *
     * todo 学习官方给出的  使用缓存仅保留k个元素 实现索引差小于等于k的方法  优势：节约了空间
     * */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer index = cache.get(nums[i]);
            if (index != null && i - index <= k) {
                return true;
            }
            cache.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> cache = new HashSet<>(Math.min(nums.length, k + 1));
        for (int i = 0; i < nums.length; i++) {
            if (cache.contains(nums[i])) {
                return true;
            }
            cache.add(nums[i]);
            if (cache.size() > k) {
                cache.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new ContainsDuplicateII().containsNearbyDuplicate2(new int[]{1, 0, 1, 1}, 1);
        System.out.println(b);
    }
}
