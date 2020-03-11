package code_double.code_1_100.code_48;

public class Test {

    /*
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * 1-3-9-7
     * 2-6-8-4
     * 需要处理
     * 行 3/2
     * 列 (3+1)/2
     *
     * 交换下标变换
     * (i,j) -> (j, l-i-1) -> (row-i-1, l-j-1) ->(l-j-1,i)
     *
     * 1 2 3 4
     * 5 6 7 8
     * 1 2 3 4
     * 1 2 3 4
     *
     * */
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("参数异常");
        }
        int n = matrix.length;
        int row = n >> 1;
        int col = (n + 1) >> 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
