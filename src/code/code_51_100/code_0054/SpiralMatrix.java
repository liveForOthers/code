package code.code_51_100.code_0054;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {


    /*
     * Input:[[1, 2, 3, 4],[5, 6, 7, 8],[9,10,11,12]]
     *
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * 行数 m 列数 n
     * 则对于第i个元素
     * 对应的下标为
     *
     *
     * */
    public List<Integer> spiralOrder(int[][] matrix) {
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

            //从上到下 遍历右侧列

            //从右到左 遍历底行

            //从下到上 遍历左侧列
        }
    }
}
