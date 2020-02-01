package code.code_201_250.code_201;

public class BitwiseANDOfNumbersRange {

    /*
     * Given a range [m, n] where 0 <= m <= n <= 2147483647,
     * return the bitwise AND of all numbers in this range, inclusive.
     *
     * Example 1:
     * Input: [5,7]
     * Output: 4
     *
     * Example 2:
     * Input: [0,1]
     * Output: 0
     *
     * todo https://leetcode.wang/leetcode-201-Bitwise-AND-of-Numbers-Range.html
     * 解法二 两种位移实现求区间与结果的方法
     *
     * */
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & (n - 1);
        }
        return n;
    }

    public static void main(String[] args) {
        int i = new BitwiseANDOfNumbersRange().rangeBitwiseAnd(5, 7);
        System.out.println(i);
    }
}
