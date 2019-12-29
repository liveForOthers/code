package code.code_51_100.code_0063;

public class UniquePathsII {

    /*
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * Note: m and n will be at most 100.
     * Example 1:
     * Input:[[0,0,0],[0,1,0],[0,0,0]]  Output: 2
     *
     * 在上一题目基础上增加了 有障碍节点  标识为1
     * 依旧使用动态规划算即可，只不过需要对障碍节点单独处理
     *
     * */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0] == null || obstacleGrid[0].length < 1) {
            return 0;
        }
        // 使用二维数组缓存历史过程  后续进行滚动数组优化减少时间复杂度
        // 也可以考虑使用原地算法优化空间复杂度到O(1) 与 二维数组 算法无本质差别 但需要把障碍标识由1 改为-1 本次不做了
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 初始化右列
        for (int i = obstacleGrid.length - 1; i >= 0; i--) {
            if (obstacleGrid[i][obstacleGrid[0].length - 1] == 1) {
                break;
            }
            dp[i][obstacleGrid[0].length - 1] = 1;
        }

        // 初始化底行
        for (int i = obstacleGrid[0].length - 1; i >= 0; i--) {
            if (obstacleGrid[obstacleGrid.length - 1][i] == 1) {
                break;
            }
            dp[obstacleGrid.length - 1][i] = 1;
        }

        // 根据历史状态求出当前节点状态  需要考虑 障碍点
        for (int i = obstacleGrid.length - 2; i >= 0; i--) {
            for (int j = obstacleGrid[0].length - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        uniquePathsWithObstacles2(new int[][]{{0, 0}, {1, 1}, {0, 0}});
    }

    /*
     * 使用滚动数组进行优化实现
     *
     * */
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0] == null || obstacleGrid[0].length < 1) {
            return 0;
        }
        boolean rowIsBiggerThanCol = obstacleGrid.length > obstacleGrid[0].length;
        // 滚动数组优化减少时间复杂度
        // 也可以考虑使用原地算法优化空间复杂度到O(1) 与 二维数组 算法无本质差别 但需要把障碍标识由1 改为-1 本次不做了
        int[] dp = new int[obstacleGrid.length];
        // 初始化
        for (int i = dp.length - 1; i >= 0; i--) {
            if (obstacleGrid[i][obstacleGrid[0].length - 1] == 1) {
                break;
            }
            dp[i] = 1;
        }
        boolean isObstacle = false;
        // 根据历史状态求出当前节点状态  需要考虑 障碍点
        for (int i = obstacleGrid[0].length - 2; i >= 0; i--) {
            if (isObstacle) {
                dp[dp.length - 1] = 0;
            } else {
                if (obstacleGrid[obstacleGrid.length - 1][i] == 1) {
                    isObstacle = true;
                    dp[dp.length - 1] = 0;
                }
            }
            for (int j = dp.length - 2; j >= 0; j--) {
                if (obstacleGrid[j][i] == 1) {
                    dp[j] = 0;
                    continue;
                }
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }
}
