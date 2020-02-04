package code.code_201_250.code_209;

public class MinimumSizeSubarraySum {

    /*
     * Given an array of n positive integers and a positive integer s,
     * find the minimal length of a contiguous subarray of which the sum ≥ s.
     * If there isn't one, return 0 instead.
     * 给定n个正整数的数组 和一个整数 s。找出最小长度的连续子数组使得其和大于等于s
     * 如果没有满足条件的数组 返回0
     * Example:
     * Input: s = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
     *
     * Follow up:
     * If you have figured out the O(n) solution,
     * try coding another solution of which the time complexity is O(n log n).
     * 如果弄清楚了线性时间复杂度解决方法
     * 尝试 O(n log n)时间复杂度方法
     *
     * 算法：
     * 双指针 滑动窗口
     * left right 如当前sum<s 则右指针向右滑动直到sum>=s 再尝试滑动左指针  找到当前最小长度
     * 时间复杂度：O(N) 空间复杂度：O(1)
     *
     * O(n log n) 想到排序，以及二分法。。排序会打乱原有顺序 不可行。 二分只能在有序时起作用
     * 没有好的思路
     *
     * TODO 学习O(n log n) 算法解决本问题：https://leetcode.wang/leetcode-202-Happy-Number.html
     * todo 主要分为两点：
     * todo 1 如何进行二分查找？  2 如何构建有序数组  长度？段和？
     * */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        boolean hasValidResult = false;
        while (right < nums.length) {
            sum += nums[right];
            if (sum >= s) {
                hasValidResult = true;
                //左指针移动缩小长度 直到sum<s 或left>right
                while (sum >= s && left <= right) {
                    sum -= nums[left];
                    left++;
                }
                res = Math.min(right - left + 2, res);
            }
            right++;
        }
        return hasValidResult ? res : 0;
    }

    public static void main(String[] args) {
        int i = new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }
}
