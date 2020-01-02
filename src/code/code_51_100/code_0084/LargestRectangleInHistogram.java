package code.code_51_100.code_0084;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {


    /*
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
     * find the area of largest rectangle in the histogram.
     *
     * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
     *
     * The largest rectangle is shown in the shaded area, which has area = 10 unit.
     *
     * Example:
     *
     * Input: [2,1,5,6,2,3]
     *
     * Output: 10
     *
     * 目标：给定n个直方图高度的矩阵，找到矩阵中直方图能组合成都最大的矩形面积
     *
     * 算法：
     * 栈空间法
     * 1 当前元素 比栈顶元素小      出栈 并计算出出栈元素高度  出栈元素之前元素的位置  到 当前元素之间的面积  更新结果面积 原因：小的height使大的height失效
     *                   大或等于 入栈
     * 2 计算方法  栈中存储当前元素下标 (cur-stack.peekIndex)*heights[peekIndex]
     * 3 栈中留有剩余元素 使用MINValue进行处理
     *
     * 时间复杂度： O(N)
     * 空间复杂度： O(N)
     *
     * 学习：
     * 1 本算法 计算时 是计算 当前元素位置 到 出栈元素 ***之前的*** 元素的位置之间的面积   因为出栈之前的元素高度比本元素高度高的都被挤出栈了，这些元素是符合要求的
     *   如 2，1，2   1入栈前 把 2挤出栈   但是计算1高度对应的矩阵 应该是 cur-（-1）（之前元素为null 取-1）-1
     *
     * 2 分治法思想
     *   2.1 找到分治点：  最小元素
     *   2.2 分治求结果最大值
     *   最差时间复杂度： n+(n-1)+...+1 = n(n+1)/2 = O(N^2) 在有序时每次查找都需要遍历一遍当前段全部节点
     *
     * 3 优化分治法查找：线段数 （数据结构回头再学   树状数组、跳跃表。。。。）
     *   感觉优化不了？每次都要构建一个新的线段树？
     *   链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
     *
     * */
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i <= heights.length; ) {
            if (stack.isEmpty() || (i < heights.length && heights[i] >= heights[stack.peek()])) {
                stack.push(i);
                i++;
            } else {
                Integer popIndex = stack.pop();
                int beginIndex = stack.isEmpty() ? -1 : stack.peek();
                int area = (i - beginIndex-1) * heights[popIndex];
                res = Math.max(res, area);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = largestRectangleArea(new int[]{2, 1, 2});
        System.out.println(i);
    }
}
