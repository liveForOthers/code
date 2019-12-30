package code.code_51_100.code_0072;

public class SetMatrixZeroes {

    /*
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
     *
     * Example 1:
     * Input:
     * [[1,1,1],[1,0,1],[1,1,1]]
     *
     * Output:
     * [[1,0,1],[0,0,0],[1,0,1]]
     *
     * Example 2:
     * Input:
     * [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     *
     * Output:
     * [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     *
     * Follow up:
     * A straight forward solution using O(mn) space is probably a bad idea.
     * A simple improvement uses O(m + n) space, but still not the best solution.
     * Could you devise a constant space solution?
     *
     * 目标 将已为0 的同行列 均设置为0
     *
     * 尽可能减少 空间复杂度
     * */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cache[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (cache[i][j] == 0) {
                    doClearRow(i, matrix);
                    doClearCol(i, matrix);
                }
            }
        }
    }

    private static void doClearRow(int row, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void doClearCol(int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    /*
     * O(N) 空间复杂度
     * */
    public void setZeroes2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (row[i]) {
                doClearRow(i, matrix);
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (col[j]) {
                doClearCol(j, matrix);
            }
        }
    }

    /*
     * O(1) 空间复杂度
     *
     * 考虑原地算法 并永常量辅助标识
     * 使用入参矩阵的
     * 1 最上方行 记录 非第一列的所有的列有无清0
     * 2 最左侧列 记录 非第一行的所有的行有无清0
     * 3 使用两个常量 分别标识 第一行 以及 第一列 是否被清零
     *
     * 学习点：在整体标记 以及行列清理时 不可再对
     *        标记行、标记列进行清理，如对其进行清理后将导致 已标记的状态可能被清为0
     *
     * */
    public static void setZeroes3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        boolean lowRow = false;
        boolean lowCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                lowCol = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                lowRow = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                doClearRow(i, matrix);
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                doClearCol(i, matrix);
            }
        }
        if (lowRow) {
            doClearRow(0, matrix);
        }
        if (lowCol) {
            doClearCol(0, matrix);
        }
    }

    public static void main(String[] args) {
        setZeroes3(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }

}
