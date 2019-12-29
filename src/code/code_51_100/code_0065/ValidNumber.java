package code.code_51_100.code_0065;

public class ValidNumber {

    /*
     * here is a list of characters that can be in a valid decimal number:
     *
     * Numbers 0-9
     * Exponent - "e"
     * Positive/negative sign - "+"/"-"
     * Decimal point - "."
     *
     * 目标：判断字符串是否为 有效数字
     *
     * 算法：
     * 1 0-9 可多次出现
     * 2 e 可以出现一次  且
     *   e前必须为数字
     *   e后可为正负号
     *   e后必须为数字
     *   e后数字不可出现 .
     * 3 . 仅可出现一次
     *   . 后必须有数字
     * 4 正负号 在e前 e后 仅可出现一次
     *   必须在数字前出现
     * 5 去掉 前缀空格 以及 后缀空格
     *
     *
     * 本次A题未通过的用例:
     * " .1 " : "." 前可没有数字
     * " .-1 ": 符号不可在'.'之后
     *
     * "46.e3": "e" 之前可以直接接'.'
     *
     * */
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length()) {
            return false;
        }
        // 下面开始处理 字符
        // 标识是否出现过正负号
        boolean sign = false;
        // 标识是否出现过e
        boolean e = false;
        // 标识是否出现过数字
        boolean digit = false;
        // 标识是否出现过'.'
        boolean point = false;
        while (index < s.length()) {
            if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                if (digit || sign || point) {
                    return false;
                }
                sign = true;
                index++;
                continue;
            }
            if (s.charAt(index) == '.') {
                if (e || point) {
                    return false;
                }
                point = true;
                index++;
                continue;
            }
            if (s.charAt(index) <= '9' && s.charAt(index) >= '0') {
                digit = true;
                index++;
                continue;
            }
            if (s.charAt(index) == 'e') {
                if (!digit || e) {
                    return false;
                }
                digit = false;
                sign = false;
                point = false;
                e = true;
                index++;
                continue;
            }
            if (s.charAt(index) == ' ') {
                break;
            }
            return false;
        }
        // 跳出循环 走到此步骤有两种情况 1 遇到' ' 2 走到最后一个下标了
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index != s.length()) {
            return false;
        }
        return digit;
    }

    public static void main(String[] args) {
        boolean number = isNumber("95a54e53");
        System.out.println(number);
    }
}
