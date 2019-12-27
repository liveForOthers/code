package code.code_1_50.code_0048;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        rotate(matrix);
        toString(matrix);
    }


    /*
     * 应确认好数组旋转 节点 旋转后 和旋转前的下标对应关系
     * 举个栗子：
     *
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     * 13 14 15 16
     *
     * 经过旋转后  2->8->15->9
     *
     * 则下标对应关系为：
     * (i,j) -> (j,n-1-i) -> (n-1-i,n-1-j) -> (n-1-j,i)
     *
     * */
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int rowLength = matrix.length >> 1;
        int colLength = (matrix[0].length + 1) >> 1;
        for (int j = 0; j < colLength; j++) {
            for (int i = 0; i < rowLength; i++) {
                int temp = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length-1-i];
                matrix[j][matrix.length-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    private static void toString(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

    }
}
