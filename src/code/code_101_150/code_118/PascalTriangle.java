package code.code_101_150.code_118;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /*
     * Input: 5
     *
     * Output:
     * [
     *    [1],
     *   [1,1],
     *  [1,2,1],
     * [1,3,3,1],
     *[1,4,6,4,1]]
     *
     * 给定行 杨辉三角 一层一层的列表
     *
     * 算法：
     * 动态规划 当前值 由上一行该位置的值以及 上一行的该位置前一位值决定
     *
     * 时间复杂度：O(N) 空间复杂度: O(N)
     * */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        List<Integer> initList = new ArrayList<>();
        initList.add(1);
        res.add(initList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRowList = res.get(i - 1);
            List<Integer> curRowList = new ArrayList<>();
            curRowList.add(1);
            for (int j = 1; j < i; j++) {
                curRowList.add(prevRowList.get(j - 1) + prevRowList.get(j));
            }
            curRowList.add(1);
            res.add(curRowList);
        }
        return res;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
