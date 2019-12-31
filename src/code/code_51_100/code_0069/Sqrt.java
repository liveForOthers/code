package code.code_51_100.code_0069;

public class Sqrt {
    /*
     * 求指定数的平方根估计值，忽略小数
     *
     * 暴力: 从0 到x/2 递增判断 直到 i^2>x 返回i-1
     *
     * 二分查找优化时间复杂度
     *
     *
     * 学习：
     * 1 二分法 变种  取到右中位数
     *   //TODO 二分法变种
     *   链接： 需要学习下：https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
     *
     * 2 对于mid*mid 要考虑溢出问题  所以要先转为long 再进行计算
     *
     * 3 TODO 取中位数方法学习
     *             // 这种取中位数的方法又快又好，是我刚学会的，原因在下面这篇文章的评论区
            // https://www.liwei.party/2019/06/17/leetcode-solution-new/search-insert-position/
            // 注意：这里得用无符号右移
            long mid = (left + right + 1) >>> 1;
     *
     * */
    public static int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("参数异常");
        }
        long left = 0;
        long right = x;
        while (right > left) {
            long mid = left + ((right - left + 1) >> 1);
            long cur = mid * mid;
            if (cur == x) {
                return (int)mid;
            }
            if (cur > x) {
                right = mid - 1;
                continue;
            }
            left = mid;
        }
        return (int)left;
    }

    public static void main(String[] args) {
        mySqrt(8);
    }
}
