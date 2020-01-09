package code.code_101_150.code_119;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    /*
     * Given a non-negative index k where k ≤ 33,
     * return the kth index row of the Pascal's triangle.
     *
     * Note that the row index starts from 0.Example:
     *
     * Input: 3
     *
     * Output: [1,3,3,1]
     *
     * Follow up:
     *
     * Could you optimize your algorithm to use only O(k) extra space?
     *
     * 目标： 给定第几行 返回杨辉三角该行的值  仅可使用给定行个空间
     *
     * 算法：
     * 滚动数组
     * 使用大小为k的数组 一行一行求  直到第k行
     *
     * 时间复杂度: O(N) 空间复杂度 O(K)
     * */
    public static List<Integer> getRow(int rowIndex) {
        if (++rowIndex <= 0) {
            return new ArrayList<>(0);
        }
        List<Integer> res = new ArrayList<>(rowIndex);
        res.add(1);
        for (int i = 1; i < rowIndex; i++) {
            // 学习：依赖的已知变量要缓存 因为之前会被覆盖
            int prev = 1;
            for (int j = 1; j < i; j++) {
                int tmp = res.get(j);
                res.set(j, prev + res.get(j));
                prev = tmp;
            }
            res.add(1);
        }
        return res;
    }

    public static void main(String[] args) {
        getRow(3);
    }
}
