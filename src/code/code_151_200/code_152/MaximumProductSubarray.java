package code.code_151_200.code_152;

public class MaximumProductSubarray {

    /*
     * Given an integer array nums, find the contiguous subarray within an array
     * (containing at least one number) which has the largest product.
     * 找出连续的子数组乘积最大值
     *
     * Example 1:
     * Input: [2,3,-2,4]
     * Output: 6
     *
     * Explanation: [2,3] has the largest product 6.
     *
     * Example 2:
     * Input: [-2,0,-1]
     * Output: 0
     *
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     *
     * 算法：
     * 动态规划
     * 存储两个量：
     * 1 包含上一个元素的  乘积最大值
     * 2 包含上一个元素的  乘积最小值
     * 遍历元素更新结果
     * 时间复杂度O(N) 空间复杂度O(1)
     *
     * 未通过case:
     * [0,2]
     * 期望输出2
     *
     * 可以不包含之前的元素
     * */
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMax = max * nums[i];
            int curMin = min * nums[i];
            max = Math.max(curMax, curMin);
            max = Math.max(max, nums[i]);
            min = Math.min(curMax, curMin);
            min = Math.min(min, nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        maxProduct(new int[]{-2, 0, -1});
    }
}
