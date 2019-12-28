package code.code_51_100.code_0056;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    /*
     * Example 1:
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     *
     * Example 2:
     * Input: [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     * 合并区间
     * 1 将区间元素 进行排序 按照开始时间 从小到大排序
     * 2 遍历一遍执行合并
     *   分为以下几种情况：[a1,a2] [b1,b2]
     *   2.1 a2<b1 两者无法合并 处理下一对
     *   2.2 a2>=b1 两者可合并 为[a1,max(a2,b2)]
     *
     * 时间复杂度：O(N*log(N)) 瓶颈在于排序耗时
     * 空间复杂度: O(N) 返回值最差情况下 返回所有元素
     * */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }
        int[][] temp = new int[intervals.length][intervals[0].length];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] prev = intervals[0];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (prev[1] < cur[0]) {
                temp[index++] = prev;
                prev = cur;
                continue;
            }
            prev[1] = Math.max(prev[1], cur[1]);
        }
        temp[index] = prev;
        int[][] res = new int[index + 1][intervals[0].length];
        for (int i = 0; i <= index; i++) {
            res[i] = temp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
