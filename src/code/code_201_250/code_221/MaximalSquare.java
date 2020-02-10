package code.code_201_250.code_221;

public class MaximalSquare {
    /*
     * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing
     * only 1's and return its area.
     *
     * Example:
     * Input:
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * Output: 4
     *
     * 算法：
     * 判断一个二维矩阵中最大矩形  需要记录以下参量
     * 1 从上到下连续为1的高度 high[i]
     * 2 遍历行
     *      当前元素为1，
     *         更新high,更新curHigh,计算当前矩阵最大值min(i-left+1,curHigh)^2 更新结果值
     *      当前元素为0，
     *         更新high,更新curHigh为max，更新left
     * 时间复杂度：O(M*N) 空间复杂度:O(N)
     *
     * 以上算法无效
     *
     * todo 官方题解  brute force 到 根据已知求未知 dp
     * 算法：
     * 暴力：
     * 从(0.0)到(i,j)位置 行程的矩形  由(i-1,j)(i-1.j-1)(i,j-1)三点到(0,0)位置可构成的矩形共同决定
     * 遍历二维矩阵 如当前元素为'1' 递归搜索(i-1,j)(i-1.j-1)(i,j-1) 位置的矩形边长  取min+1 更新结果值
     *
     * 暴力未通过用例[['1']] 期望输出1 实际输出0
     * 原因：遍历时从1开始遍历行列，而且未做边界初始化
     * 警示：深度搜索最好从0开始处理，如需要跨越边界处理  考虑数据初始化问题
     *
     * 优化：
     * 暴力法有太多重复计算 可以用二维数组缓存起来  利用滚动数组后可以优化到1维度空间复杂度
     *
     * 时间复杂度:O(N^2) 空间复杂度:O(N)
     * */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int len = calculateSquareLength(matrix, i, j);
                    res = Math.max(res, len * len);
                }
            }
        }
        return res;
    }

    private int bfs(char[][] matrix, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (matrix[i][j] != '1') {
            return 0;
        }
        return calculateSquareLength(matrix, i, j);
    }

    private int calculateSquareLength(char[][] matrix, int i, int j) {
        int left = bfs(matrix, i - 1, j);
        int head = bfs(matrix, i, j - 1);
        int leftHead = bfs(matrix, i - 1, j - 1);
        int min = Math.min(left, head);
        min = Math.min(min, leftHead);
        min++;
        return min;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1'}
        };
        int i = new MaximalSquare().maximalSquare4(matrix);
        System.out.println(i);
    }

    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        //初始化
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                res = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                min = Math.min(min, dp[i - 1][j - 1]);
                dp[i][j] = min + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

    /*
     * 去掉dp的初始化操作 减少了一半的时间消耗
     * */
    public int maximalSquare3(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        //初始化
        int res = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    continue;
                }
                int min = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                dp[i][j] = min + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

    /*
     * 滚动数组 空间复杂度优化到线性复杂度
     * */
    public int maximalSquare4(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] dp = new int[matrix[0].length + 1];
        //初始化
        int res = 0;
        for (int i = 1; i <= matrix.length; i++) {
            //缓存lefthead 以及left
            int leftHead = 0;
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[j] = 0; //todo 未通过用例，此条件必须更新 否则为上一行的脏数据
                    continue;
                }
                int nextLeftHead = dp[j];
                int min = Math.min(Math.min(leftHead, dp[j - 1]), nextLeftHead);
                dp[j] = min + 1;
                res = Math.max(res, dp[j]);
                leftHead = nextLeftHead;
            }
        }
        return res * res;
    }
}
