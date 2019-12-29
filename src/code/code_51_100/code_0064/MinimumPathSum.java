package code.code_51_100.code_0064;

public class MinimumPathSum {

    /*
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which
     * minimizes the sum of all numbers along its path.
     * Note: You can only move either down or right at any point in time.
     * Example:
     * Input: [[1,3,1],[1,5,1],[4,2,1]]   Output: 7
     *
     * 目标： 找出从左上角开始点 到 右下角终点 的最小路径和
     *
     * 动态规划  滚动数组
     * */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        for (int i = grid.length - 2; i >= 0; i--) {
            dp[i][grid[0].length - 1] = grid[i][grid[0].length - 1] + dp[i + 1][grid[0].length - 1];
        }
        for (int i = grid[0].length - 2; i >= 0; i--) {
            dp[grid.length - 1][i] = grid[grid.length - 1][i] + dp[grid.length - 1][i + 1];
        }
        // 根据已知求未知
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        minPathSum2(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    /*
     * 滚动数组优化空间复杂度
     * */
    public static int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        // 从尾巴行 向首行  单列滚动
        int[] dp = new int[grid.length];
        dp[grid.length - 1] = grid[grid.length - 1][grid[0].length - 1];
        for (int i = grid.length - 2; i >= 0; i--) {
            dp[i] = grid[i][grid[0].length - 1] + dp[i + 1];
        }
        // 根据已知求未知
        for (int i = grid[0].length - 2; i >= 0; i--) {
            // 遍历不同的列之前 要先更新该列 尾巴行节点值
            dp[grid.length - 1] += grid[grid.length - 1][i];
            for (int j = grid.length - 2; j >= 0; j--) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + grid[j][i];
            }
        }
        return dp[0];
    }
}
