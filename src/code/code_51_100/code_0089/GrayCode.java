package code.code_51_100.code_0089;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    /*
     * The gray code is a binary numeral system where two successive values differ in only one bit.
     * 格雷码是二进制系统数字，两个相邻数字的二进制表示仅1位不同
     * Given a non-negative integer n representing the total number of bits in the code,
     * print the sequence of gray code. A gray code sequence must begin with 0.
     * 给定数字n  表示二进制数字位数，打印格雷码序列，一个格雷码序列必须以0开始
     * Example 1:
     *
     * Input: 2
     *
     * Output: [0,1,3,2]
     *
     * Explanation:
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     *
     * For a given n, a gray code sequence may not be uniquely defined.
     * For example, [0,2,3,1] is also a valid gray code sequence.
     *
     * 00 - 0
     * 10 - 2
     * 11 - 3
     * 01 - 1
     *
     * 分析：
     * 1 n = 0
     *   0 - 0
     *
     * 2 n = 1
     *   0 - 0
     *   1 - 1
     * 3 n = 2
     *   00 - 0
     *   01 - 1
     *   11 - 3
     *   10 - 2
     * 4 n = 3
     *   000 - 0
     *   001 - 1
     *   011 - 3
     *   010 - 2
     *   110 - 6
     *   111 - 7
     *   101 - 5
     *   100 - 4
     *
     * 算法：
     * 只想到了  缓存已使用过的code+遍历每一位尝试变更该位，如不在code中，则作为下一个格列码
     * 时间复杂度：O(2^n * 32) 空间复杂度：O(2^n)  共缓存2^n个数
     *
     * 学习：
     * 1 找规律(镜面对称法)
     *
     * n=1
     *     0 - 0
     *     1 - 1
     *
     * n=2
     *   0 0 - 0 一样 A
     *   0 1 - 1 一样 B
     * 镜子
     *   1 1 - 3 B+(1<<1)
     *   1 0 - 2 A+(1<<1)
     *
     * n=3
     * 0 0 0 - 0 一样 A
     * 0 0 1 - 1 一样 B
     * 0 1 1 - 3 一样 C
     * 0 1 0 - 2 一样 D
     * 镜子
     * 1 1 0 - 6 D+(1<<2)
     * 1 1 1 - 7 C+(1<<2)
     * 1 0 1 - 5 B+(1<<2)
     * 1 0 0 - 4 A+(1<<2)
     *
     * 2 找规律
     * n = 3
     *   000 - 0 最后一位取反 -->
     *   001 - 1 最后一位1的位置左侧取反 -->
     *   011 - 3 最后一位取反 -->
     *   010 - 2 最后一位1的位置左侧取反 -->
     *   110 - 6 最后一位取反 -->
     *   111 - 7 最后一位1的位置左侧取反 -->
     *   101 - 5 最后一位取反 -->
     *   100 - 4 结束
     *
     * 3 公式法
     *
     * 时间复杂度:O（2^n） 空间复杂度O(2^n) 结果需要返回2^n个数据列表
     * */
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        res.add(0);
        for (int i = 1; i <= n; i++) {
            int adder = 1 << (i - 1);
            for (int j = 1; j <= adder; j++) {
                res.add(res.get(adder - j) + adder);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        grayCode2(3);
    }

    public static List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        res.add(0);
        int count = 1 << n;
        int prev = 0;
        for (int i = 0; i < count - 1; i++) {
            // 奇数 最后一位1左侧取反
            // 学习 取反通过 与该位为1的数进行异或实现
            if ((i & 1) == 1) {
                int val = (prev & -prev) << 1;
                prev = prev ^ val;
                res.add(prev);
                /*int temp = prev;
                for (int j = 0; j < 32; j++) {
                    if ((temp & 1) == 1) {
                        prev = prev ^ ((1 << j) << 1);
                        res.add(prev);
                        break;
                    }
                    temp = temp >> 1;
                }*/
            } else {
                // 偶数 最后一位取反
                // 学习  最后一位取反 通过 与1 进行异或实现
                prev = prev ^ 1;
                res.add(prev);
            }
        }
        return res;
    }
}
