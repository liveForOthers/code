package code.code_101_150.code_128;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /*
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     *
     * Your algorithm should run in O(n) complexity.
     *
     * Example:
     *
     * Input: [100, 4, 200, 1, 3, 2]
     *
     * Output: 4
     *
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * 目标： 给定无序数组 返回最长连续序列长度 线性时间复杂度
     *
     * 算法：
     * 难度在于线性时间复杂度 不能排序
     *
     * 缓存 并从一个点开始左右搜索，存在从缓存删掉 继续搜索直到不存在
     *
     * 时间复杂度：O（N） 空间复杂度：O（N）
     *
     * */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        Set<Integer> cache = new HashSet<>();
        for (int cur : nums) {
            cache.add(cur);
        }
        int threshold = (nums.length & 1) == 1 ? (nums.length >> 1) + 1 : (nums.length >> 1);
        for (int i = 0; i < nums.length - res; i++) {
            int cur = nums[i];
            if (!cache.contains(cur)) {
                continue;
            }
            cache.remove(cur);
            int left = cur - 1;
            while (cache.contains(left)) {
                cache.remove(left);
                left--;
            }
            int right = cur + 1;
            while (cache.contains(right)) {
                cache.remove(right);
                right++;
            }
            int count = right - left - 1;
            if (count >= threshold) {
                return count;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }
}
