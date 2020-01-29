package code.code_151_200.code_190;

public class ReverseBits {


    /*
     * Reverse bits of a given 32 bits unsigned integer.
     *
     * 给定无符号数  将其按位进行反转
     * 算法：
     * 遍历所有位
     *
     * todo 学习通过位移实现旋转位 https://leetcode.wang/leetcode-190-Reverse-Bits.html
     * */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 1; i <= 32; i++) {
            // 取最后一位
            int cur = n & 1;
            // 加到res中
            res = (res << 1) | cur;
            // 去除最后位
            n = n >> 1;
        }
        return res;
    }
}
