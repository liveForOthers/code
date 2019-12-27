package code.code_1_50.code_0007;

public class ReverseInteger {
    /*
     * 需要注意的点：
     * 1 对负数的处理 要用sign记录正负号  并转为整数处理
     * 2 对于int值的计算 要考虑到整数越界问题
     *
     * */
    public int reverse(int x) {
        if (x == 0)
            return x;
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        int num = 0;
        while (x != 0) {
            int cur = x % 10;
            x = x / 10;
            if (num > (Integer.MAX_VALUE - cur) / 10) {
                return 0;
            }
            num = num * 10 + cur;
        }
        return num * sign;
    }
}
