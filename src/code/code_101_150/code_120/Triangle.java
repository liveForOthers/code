package code.code_101_150.code_120;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    /*
     * Given a triangle, find the minimum path sum from top to bottom.
     * Each step you may move to adjacent numbers on the row below.
     *
     * For example, given the following triangle
     *
     * [
     *   [2],
     *  [3,4],
     * [6,5,7],
     *[4,1,8,3]]
     *
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     *
     * Note:
     *
     * Bonus point if you are able to do this using only O(n) extra space,
     * where n is the total number of rows in the triangle.
     *
     * 目标：
     * 给定三角矩阵，返回从顶到底和最小的path
     * path 要求上下节点相邻  比如下层索引为 i 则上层可构成path的索引为 i-1 以及 i
     *
     * 算法:
     * 动态规划，
     * cache[i][j] 表示第i层第j位元素到最底层的最小路径和
     * cache[i][j] = min(cache[i+1][j],cache[i+1][j+1])+array[i][j]
     *
     * 时间复杂度:O(m*n) 空间复杂度:O(m*n)
     *
     * 滚动数组：
     * 时间复杂度:O(m*n) 空间复杂度:O(m)
     *
     * 原地算法:O(m*n) 空间复杂度:O(1)
     * */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null ||
                triangle.size() == 0 ||
                triangle.get(0) == null ||
                triangle.get(0).size() == 0) {
            return 0;
        }
        int lastRow = triangle.size() - 1;
        int[][] cache = new int[triangle.size()][triangle.get(lastRow).size()];
        // init
        for (int i = 0; i < triangle.get(lastRow).size(); i++) {
            cache[lastRow][i] = triangle.get(lastRow).get(i);
        }
        // 根据已知求未知 自底向顶推进
        lastRow--;
        for (int i = lastRow; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                cache[i][j] = Math.min(cache[i+1][j],cache[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return cache[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(2);
        triangle.add(one);
        one = new ArrayList<>();
        one.add(3);
        one.add(4);
        triangle.add(one);
        one = new ArrayList<>();
        one.add(6);
        one.add(5);
        one.add(7);
        triangle.add(one);
        one = new ArrayList<>();
        one.add(4);
        one.add(1);
        one.add(8);
        one.add(3);
        triangle.add(one);
        minimumTotal2(triangle);

    }


    /*
    * 使用滚动数组进行优化
    * */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null ||
                triangle.size() == 0 ||
                triangle.get(0) == null ||
                triangle.get(0).size() == 0) {
            return 0;
        }
        int lastRow = triangle.size() - 1;
        int[] cache = new int[triangle.get(lastRow).size()];
        // init
        for (int i = 0; i < triangle.get(lastRow).size(); i++) {
            cache[i] = triangle.get(lastRow).get(i);
        }
        // 根据已知求未知 自底向顶推进
        lastRow--;
        for (int i = lastRow; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                cache[j] = Math.min(cache[j],cache[j+1])+triangle.get(i).get(j);
            }
        }
        return cache[0];
    }
}
