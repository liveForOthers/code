package code.code_51_100.code_0054;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /*
     * Input:[[1, 2, 3, 4],[5, 6, 7, 8],[9,10,11,12]]
     *
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * 模拟题 画画就能想出来
     * 时间复杂度O(m*n) 空间复杂度O(m*n) 因为要返回一个list 空间复杂度无法减少
     * */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int lowRow = 0;
        int lowCol = 0;
        int highRow = matrix.length - 1;
        int highCol = matrix[0].length - 1;
        while (lowRow <= highRow && lowCol <= highCol) {
            //从左到右 遍历顶行
            for (int i = lowCol; i <= highCol; i++) {
                res.add(matrix[lowRow][i]);
            }
            lowRow++;
            if (lowRow > highRow) {
                break;
            }
            //从上到下 遍历右侧列
            for (int i = lowRow; i <= highRow; i++) {
                res.add(matrix[i][highCol]);
            }
            highCol--;
            if (lowCol > highCol) {
                break;
            }
            //从右到左 遍历底行
            for (int i = highCol; i >= lowCol; i--) {
                res.add(matrix[highRow][i]);
            }
            highRow--;
            if (lowRow > highRow) {
                break;
            }
            //从下到上 遍历左侧列
            for (int i = highRow; i >= lowRow; i--) {
                res.add(matrix[i][lowCol]);
            }
            lowCol++;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})) {
            System.out.println(i);
        }
    }
}
