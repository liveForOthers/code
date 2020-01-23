package code.code_151_200.code_172;

public class FactorialTrailingZeroes {
    /*
     * 给定数n 计算 n! 尾部0的个数
     * 考虑尾部0的来源取决于5的个数
     * 5 10 15 20 都包含1个5
     * 25 包含两个5
     * 5*1 5*2 ...5*m
     * 算法：
     * 从5 开始迭代计算到n 共有多少个5
     * 每隔5个数  会出现一个5
     * 每隔25个数 会出现两个5
     * 每隔125个数 会出现三个5
     * 。。。
     *
     * todo 回顾
     * */
    public static int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int base = 5;
        int res = 0;
        while (base <= n) {
            res += countFive(base);
            base = base + 5;
        }
        return res;
    }

    private static int countFive(int num) {
        if (num < 1) {
            return 0;
        }
        int res = 0;
        while (num % 5 == 0) {
            res++;
            num = num / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        trailingZeroes2(15);
    }

    public static int trailingZeroes2(int n) {
        if (n < 5) {
            return 0;
        }
        int res = 0;
        while (n > 0) {
            n = n / 5;
            res += n;
        }
        return res;
    }
}
