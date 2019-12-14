package code.code_0029;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int divide = divide2(100, 3);
        System.out.println(divide);
    }
    /*
    *  本题 算法思想都是用 倍数相减 实现除法运算
    *  难点在于 边界处理 因为 int 负数最大值转为正数 比正数最大值大1
    *  转为long处理  但对  Integer.MIN_VALUE 除以 -1 为啥返回 Integer.MAX_VALUE？
    *
    *  运算效率 用 1<<bit 取代power 效率更好些
    *  而且 1<<bit 能保证 在bit减为0 之前 被除数变为0
    * */
    public static int divide1(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if (dividend < 0 && divisor < 0) {
        } else if (dividend < 0 || divisor < 0) {
            sign = -1;
        }
        int res = 0;
        long left = dividend;
        left = Math.abs(left);
        long baseNum = divisor;
        baseNum = Math.abs(baseNum);
        int power = 1;
        while (left >= baseNum) {
            while (left >= baseNum * power) {
                left -= baseNum * power;
                res += power;
                power++;
            }
            power = 1;
        }
        return res * sign;
    }

    public static int divide2(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if (dividend < 0 && divisor < 0) {
        } else if (dividend < 0 || divisor < 0) {
            sign = -1;
        }
        int res = 0;
        long left = dividend;
        left = Math.abs(left);
        long baseNum = divisor;
        baseNum = Math.abs(baseNum);
        int bit = 0;
        while (left >= (baseNum << bit)) {
            bit++;
        }
        while (left >= baseNum) {
            if (bit > 0) {
                bit--;
            }
            long cache = baseNum << bit;
            if (left >= cache) {
                res += (1 << bit);
                left -= cache;
            }
        }
        return res * sign;
    }
}
