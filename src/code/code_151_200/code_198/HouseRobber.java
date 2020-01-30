package code.code_151_200.code_198;

public class HouseRobber {

    /*
     * 目标：不抢相邻银行的情况下 获得的最大收益
     * 算法：
     * 分为
     * 1 可抢第一家 不抢最后一家
     *   cur prev
     * 2 不抢第一家 可以抢最后一家
     *
     * ps 第一家和最后一家不算相邻的。。
     * */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        /*if (nums.length == 1) {
            return nums[0];
        }
        int first = rob(nums, 0, nums.length - 2);
        int notFirst = rob(nums, 1, nums.length - 1);
        return Math.max(first, notFirst);*/
        return rob(nums, 0, nums.length - 1);
    }

    private static int rob(int[] nums, int begin, int end) {
        if (begin == end) {
            return nums[begin];
        }
        if (begin == end - 1) {
            return Math.max(nums[begin], nums[end]);
        }
        // 包含前一个元素的最大值
        int prev = nums[begin] + nums[begin + 2];
        // 包含前前一个元素的最大值
        int pp = nums[begin + 1];
        // 包含前前前一个元素，且不包含前一个元素的最大值
        int ppp = nums[begin];
        for (int i = begin + 3; i <= end; i++) {
            int cur = Math.max(pp, ppp) + nums[i];
            ppp = pp;
            pp = prev;
            prev = cur;
        }
        return Math.max(prev, pp);
    }

    public static void main(String[] args) {
        int rob = rob(new int[]{2, 1, 1, 2});
        System.out.println(rob);
    }
}
