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
     *
     * */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        throw new IllegalArgumentException("待coding");
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        int i = new MaximalSquare().maximalSquare(matrix);
        System.out.println(i);
    }
}
