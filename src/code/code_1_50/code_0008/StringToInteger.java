package code.code_1_50.code_0008;

/*
 * 字符串转为整数
 * 需要处理以下几点：
 * 1 常规参数校验
 * 2 前缀为多个连续空格字符组成的前缀
 * 3 正负号
 * 4 非数字
 * 5 边界溢出（对于正负 分别处理）
 *
 * 本次A题目时，未对正负号处理号，1 正负号仅能有一个 2 为正负号下表要增加
 *
 * */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        int sign = 1;
        if (index < str.length() && str.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (index < str.length() && str.charAt(index) == '+') {
            index++;
        }
        int res = 0;
        while (index < str.length() && isNum(str.charAt(index))) {
            int cur = str.charAt(index) - '0';
            // 边界溢出判断
            if (sign == -1) {
                if (res > Integer.MAX_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
                if (res * 10 > Integer.MAX_VALUE - cur) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (res > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                }
                if (res * 10 > Integer.MAX_VALUE - cur) {
                    return Integer.MAX_VALUE;
                }
            }
            res = res * 10 + cur;
            index++;
        }
        return res * sign;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
