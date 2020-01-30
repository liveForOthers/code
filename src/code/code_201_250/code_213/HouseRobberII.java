package code.code_201_250.code_213;

public class HouseRobberII {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int first = rob(nums, 0, nums.length - 2);
        int notFirst = rob(nums, 1, nums.length - 1);
        return Math.max(first, notFirst);
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
        int rob = rob(new int[]{1,2,3,1});
        System.out.println(rob);
    }
}
