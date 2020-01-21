package code.code_101_150.code_150;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {


    /*
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     *
     * Note:
     *
     * Division between two integers should truncate toward zero.
     *
     * The given RPN expression is always valid. That means the expression would always evaluate
     * to a result and there won't be any divide by zero operation.
     *
     * Example 1:
     * Input: ["2", "1", "+", "3", "*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     *
     * Example 2:
     * Input: ["4", "13", "5", "/", "+"]
     * Output: 6
     * Explanation: (4 + (13 / 5)) = 6
     *
     * 算法：
     * 实现四则运算 使用栈即可遇到数入栈，遇到运算符出栈运算完再入栈
     *
     * 时间复杂度：O(N) 空间复杂度：O(N)
     * */
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            int code = find(cur);
            if (code < 0) {
                stack.push(Integer.parseInt(cur));
                continue;
            }
            Integer num1 = stack.pop();
            Integer num2 = stack.pop();
            if (code == 1) {
                stack.push(num1 + num2);
            } else if (code == 2) {
                stack.push(num2 - num1);
            } else if (code == 3) {
                stack.push(num2 * num1);
            } else if (code == 4) {
                stack.push(num2 / num1);
            }
        }
        return stack.pop();
    }

    private static int find(String cur) {
        if (cur.equals("+")) {
            return 1;
        } else if (cur.equals("-")) {
            return 2;
        } else if (cur.equals("*")) {
            return 3;
        } else if (cur.equals("/")) {
            return 4;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = evalRPN(new String[]{"12", "23", "-"});
        System.out.println(i);
    }
}
