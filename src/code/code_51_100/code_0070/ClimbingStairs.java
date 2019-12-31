package code.code_51_100.code_0070;

public class ClimbingStairs {

    /*
     * Input: 3  Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     * 爬楼梯 经典题目 每次跳1步 或2步  求跳到第n阶的方法个数
     *
     * 动态规划 f(n) = f(n-1)+f(n-2)
     *
     * 记录前面两次的方法个数求和即可
     *
     * */
    public static int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int prev = 1;
        int cur = 1;
        n--;
        while (n-- > 0) {
            int temp = cur;
            cur += prev;
            prev = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int i = climbStairs(3);
    }
}
