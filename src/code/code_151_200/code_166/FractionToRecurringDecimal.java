package code.code_151_200.code_166;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    /*
     * Given two integers representing the numerator and denominator of a fraction,
     * return the fraction in string format.
     * 实现处罚，如结果为循环小数，将循环小数进行表示
     * If the fractional part is repeating, enclose the repeating part in parentheses.
     *
     * Example 1:
     *
     * Input: numerator = 1, denominator = 2
     * Output: "0.5"
     *
     * Example 2:
     * Input: numerator = 2, denominator = 1
     * Output: "2"
     *
     * Example 3:
     * Input: numerator = 2, denominator = 3
     * Output: "0.(6)"
     *
     * 算法：一个商值 一个余数 可以解决非无限循环小数
     * 循环小数通过 比较余数来判断
     *
     * todo 未通过case：-50  8
     * 原因： 需要先对符号位进行处理
     *
     * 学习：数字考虑  1 符号位  2 超过整形边界问题
     * */
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        if((numerator<0 && denominator>0) || (numerator>0 && denominator<0)){
            res.append('-');
        }
        long numera = numerator;
        long denom = denominator;
        numera = Math.abs(numera);
        denom = Math.abs(denom);

        long left = numera;
        Map<Long, Integer> cache = new HashMap<>();
        long cur = left / denom;
        left = left % denom;
        res.append(cur);
        StringBuilder decimal = new StringBuilder();
        while (left != 0) {
            Integer index = cache.get(left);
            if (index != null) {
                //有循环
                res.append('.');
                res.append(decimal.substring(0, index));
                res.append('(');
                res.append(decimal.substring(index, decimal.length()));
                res.append(')');
                return res.toString();
            }
            cur = left * 10;
            long num = cur / denom;
            cache.put(left, decimal.length());
            decimal.append(num);
            left = cur % denom;
        }
        if (decimal.length() != 0) {
            res.append('.');
        }
        res.append(decimal);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = fractionToDecimal(Integer.MIN_VALUE, 3);
        System.out.println(s);
    }
}
