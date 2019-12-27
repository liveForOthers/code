package code.code_51_100.code_0053;

public class MaximumSubarray {

    /*
     * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer
     * approach, which is more subtle.
     *
     * 目标：找到给定数组中和最大的子数组
     *
     * 时间复杂度:O(N) 空间复杂度:O(1)
     *
     * 观察给定示例 简单分析即可总结出方法
     * 1 两个变量  一个维护 全局最优  一个维护 前置连续最优
     * 2 全局最优 每次都比较更新
     * 3 前置连续最优 根据当前前置值确定策略
     *       如当前前置小于0，则抛弃当前前置，更新前置为当前元素
     *       如当前前置大于等于0，则前置更新为 当前前置与当前元素的和
     *
     * */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev < 0) {
                prev = nums[i];
            } else {
                prev = prev + nums[i];
            }
            res = Math.max(res, prev);
        }
        return res;
    }
}
