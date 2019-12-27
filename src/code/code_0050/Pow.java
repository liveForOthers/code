package code.code_0050;

public class Pow {

    /*
     * Example 1:Input: 2.00000, 10  Output: 1024.00000
     * Example 2:Input: 2.10000, 3   Output: 9.26100
     * Example 3:Input: 2.00000, -2  Output: 0.25000
     * Note: -100.0 < x < 100.0
     * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
     *
     * 借鉴点:
     * 边界处理  输入为int 则取绝对值时 需要考虑 −2^31 取正数 边界溢出  转化为long再进行处理
     *
     * 共两种算法  三中解决方式
     * 1 求n次幂 则遍历n次即可  时间复杂度O(N) 空间复杂度O(1)
     *
     * 快速幂等法，借鉴二分思想，将求n次幂的 问题 转化为 求 (n>>1)次幂的问题
     * 需要确定 n 为奇数还是偶数
     *
     * 2 递归快速幂等法  时间复杂度 O(logN) 空间复杂度 O(logN)（因为递归会压栈 存储上一次的状态）
     * 3 循环快速幂等法  时间复杂度 O(logN) 空间复杂度 O(1)
     *
     * */
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        boolean negative = n < 0;
        long num = n;
        double res = dichotomyPow2(x, Math.abs(num));
        return negative ? (1.0 / res) : res;
    }

    private static double dichotomyPow1(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double dichotoRes = dichotomyPow1(x, n >> 1);
        return n % 2 == 0 ? (dichotoRes * dichotoRes) : (dichotoRes * dichotoRes * x);
    }

    public static void main(String[] args) {
        double v = myPow(2, 6);
        System.out.println(v);
    }

    /*
     *
     * 迭代方法思想追溯：
     * 如求 x^(10)<10> = x^(1010)<2> = x^(1*2^3 + 0*2^2 + 1*2^1 + 0*2^0)
     *                              = x^(1*2^3) * x^(0*2^2) * x^(1*2^1) * x^(0*2^0)
     *                              = x^(2^3) * 1 * x^(2^1) * 1
     *
     * 因此 对于 指数 n 在取决对值后 即可 进行每次迭代移动一位进行处理
     * 如果当前位为1 则 更新结果
     * 如果当前位为0 则 结果不变
     *
     * 同时需要维护一个 当前位为1 的值  变化为
     * 1bit  2bit   3bit     4bit
     * x     x^2    (x^2)^2  (x^(2^2))^2
     *
     * */
    private static double dichotomyPow2(double x, long n) {
        double prev = x;
        double res = 1;
        for (long i = n; i > 0; i = i >> 1) {
            if ((i & 1) == 1) {
                res *= prev;
            }
            prev = prev * prev;
        }
        return res;
    }
}
