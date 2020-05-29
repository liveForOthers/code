package code.code_151_200.code_198;

import java.util.HashMap;
import java.util.Map;

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
     * todo 当前最大值计算 需要依赖 pp 以及ppp  复习思想
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

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<String, Integer> cache = new HashMap<>();
        return getMaxRobEarn(nums, 0, nums.length, cache);
    }

    private int getMaxRobEarn(int[] nums, int beginIndex, int endIndex, Map<String, Integer> cache) {
        if (endIndex <= beginIndex) {
            return 0;
        }
        String key = beginIndex + ":" + endIndex;
        Integer value = cache.get(key);
        if(value != null) {
            return value;
        }
        int robWithFirst = nums[beginIndex] + getMaxRobEarn(nums, beginIndex + 2, nums.length, cache);
        int robWithoutFirst = getMaxRobEarn(nums, beginIndex + 1, nums.length, cache);
        int result = Math.max(robWithFirst, robWithoutFirst);
        cache.put(key, result);
        return result;
    }

    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] = max(dp[i-2] + nums[i], dp[i-1])
        int pp = nums[0];
        int p = nums.length > 1 ? Math.max(nums[0], nums[1]) : pp;
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(pp + nums[i], p);
            pp = p;
            p = cur;
        }
        return p;

    }
}
