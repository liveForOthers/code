package code.code_51_100.code_0055;

public class JumpGame {

    /*
     * Example 1:Input: [2,3,1,1,4] Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to
     * the last index.
     *
     * Example 2:Input: [3,2,1,0,4] Output: false
     * Explanation: You will always arrive at index 3 no matter what.
     * Its maximum jump length is 0, which makes it impossible to
     * reach the last index.
     *
     * 给定一个数组，从index为0起步 判定是否能跳到最后一个节点
     *
     * 贪心算法： 只关心能到达最远的下标 大于等于最尾部下标位置即可
     *
     * */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int next = 0;
        for (int i = 0; i <= next; i++) {
            next = Math.max(next, i + nums[i]);
            if (next >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
