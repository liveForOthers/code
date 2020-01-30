package code.code_151_200.code_191;

public class NumberOf1Bits {

    /*
     * 返回给定数中1的个数
     * 算法：
     * 1 暴力：遍历每一位 判断计数
     * 2 与减一法 遍历1出现的次数即可
     * 如
     * 1001 & 1000 = 1000
     * 0110 & 0101 = 0100
     * 1000 & 0111 = 0000
     * n&(n-1) 结果为 把 数最右边的 1 置为 0。
     * */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
