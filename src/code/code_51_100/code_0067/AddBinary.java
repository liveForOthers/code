package code.code_51_100.code_0067;

import java.util.Deque;
import java.util.LinkedList;

public class AddBinary {

    /*
     * Given two binary strings, return their sum (also a binary string).
     * The input strings are both non-empty and contains only characters 1 or 0.
     * Example 1:
     * Input: a = "11", b = "1" Output: "100"
     * Example 2:
     * Input: a = "1010", b = "1011" Output: "10101"
     *
     * 计算两个二进制串的和  按位处理即可 结果可以使用栈存储 返回前再吐出来
     *
     * */
    public static String addBinary(String a, String b) {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return "";
        }
        Deque<Character> stack = new LinkedList<>();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carryValue = 0;
        while (indexA >= 0 || indexB >= 0 || carryValue > 0) {
            int valueA = indexA >= 0 ? a.charAt(indexA) - '0' : 0;
            int valueB = indexB >= 0 ? b.charAt(indexB) - '0' : 0;
            int cur = valueA + valueB + carryValue;
            if (cur >= 2) {
                carryValue = 1;
                if (cur == 2) {
                    stack.push('0');
                } else {
                    stack.push('1');
                }
            } else {
                carryValue = 0;
                if (cur == 1) {
                    stack.push('1');
                } else {
                    stack.push('0');
                }
            }
            indexA--;
            indexB--;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        addBinary2("1111", "1111");
    }

    /*
     * 使用栈 可能没有直接使用StirngBuilder 再reverse高效
     * */
    public static String addBinary2(String a, String b) {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carryValue = 0;
        while (indexA >= 0 || indexB >= 0 || carryValue > 0) {
            int valueA = indexA >= 0 ? a.charAt(indexA--) - '0' : 0;
            int valueB = indexB >= 0 ? b.charAt(indexB--) - '0' : 0;
            int cur = valueA + valueB + carryValue;
            carryValue = cur / 2;
            res.append(cur % 2);
        }
        return res.reverse().toString();
    }
}
