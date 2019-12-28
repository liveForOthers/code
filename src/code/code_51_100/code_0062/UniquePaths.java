package code.code_51_100.code_0062;

public class UniquePaths {

    /*
     *
     * Input: m = 3, n = 2 Output: 3
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down
     * 2. Right -> Down -> Right
     * 3. Down -> Right -> Right
     *
     * 背景：机器人在矩阵的左上角，终点在矩阵的右下角，机器人只能向右或向下走
     * 本题的目标是找出 机器人到达终点的独立路径个数
     *
     * 因为 第 (i,j)节点 到达终点独立路径个数 依赖于 第(i,j+1) 以及第(i+1,j)节点 的独立路径个数之和
     * 使用动态规划 从终点向开始点找答案
     *
     * dp[i][j] 表示 第 (i,j)节点 到达终点独立路径个数
     * dp[i][j] = 1 dp[i+1][j]+dp[i][j+1], i+1、j+1均未越界
     *            2 dp[i+1][j], i+1未越界 且 j+1越界
     *            3 dp[i][j+1], j+1未越界 且 i+1越界
     *
     * 时间复杂度：O(N^2)  空间复杂度：O(N^2)
     *
     * 滚动数组:  时间复杂度：O(N^2)  空间复杂度：O(N)
     *
     * */
    public static int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        //初始化边界
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        // 根据已知求未知 并缓存  第二种方法可以使用滚动数组 时间复杂度不变 空间复杂度优化
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        uniquePaths2(7, 3);
    }

    public static int uniquePaths2(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        boolean mIsBiggerThanN = m > n;
        int[] dp = new int[mIsBiggerThanN ? n : m];
        //初始化边界
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        // 根据已知求未知 并缓存  使用滚动数组 时间复杂度不变 空间复杂度优化
        for (int i = (mIsBiggerThanN ? m : n) - 2; i >= 0; i--) {
            for (int j = (mIsBiggerThanN ? n : m) - 2; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }
        return dp[0];
    }
}
