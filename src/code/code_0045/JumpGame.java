package code.code_0045;

public class JumpGame {

    public static void main(String[] args) {
        int jump = jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);
    }
    /*
     * Given an array of non-negative integers,
     * you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     *
     * 目标 输出达到最后的 最少的步数
     * Input: [2,3,1,1,4]  Output: 2
     *
     * 贪心： 两个变量 1 当前阶段可达到的下一个点 2 需要经过的步数
     * 前一个阶段走完  更新步数
     * 下一阶段的可达点为 前一个阶段可以到达的最远的点
     *
     * */
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        int step = 0;
        int next = 0;
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            temp = Math.max(temp, i + nums[i]);
            if (i == next) {
                step++;
                if (temp <= i) {
                    return -1;
                }
                next = temp;
            }
        }
        return step;
    }
}
