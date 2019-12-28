package code.code_51_100.code_0059;

public class SpiralMatrixII {
    /*
     * Input: 3
     * Output:
     * [[ 1, 2, 3 ],[ 8, 9, 4 ],[ 7, 6, 5 ]]
     *
     * 与遍历螺旋矩阵的差别是  这次是一边遍历 一边set值  本质无差别
     *
     * 四指针 遍历即可
     *
     * 学习点： 编码时仔细点，尤其循环中 套四个子循环的 退出条件不要大意
     * */
    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        int lowRow = 0;
        int highRow = n - 1;
        int lowCol = 0;
        int highCol = n - 1;
        int value = 1;
        while (lowCol <= highCol && lowRow <= highRow) {
            for (int i = lowCol; i <= highCol; i++) {
                res[lowRow][i] = value++;
            }
            lowRow++;
            for (int i = lowRow; i <= highRow; i++) {
                res[i][highCol] = value++;
            }
            highCol--;
            if (lowCol > highCol || lowRow > highRow) {
                break;
            }
            for (int i = highCol; i >= lowCol; i--) {
                res[highRow][i] = value++;
            }
            highRow--;
            for (int i = highRow; i >= lowRow; i--) {
                res[i][lowCol] = value++;
            }
            lowCol++;
        }
        return res;
    }
}
