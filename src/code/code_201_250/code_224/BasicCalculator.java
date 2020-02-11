package code.code_201_250.code_224;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {

    /*
     * Implement a basic calculator to evaluate a simple expression string.
     * The expression string may contain open ( and closing parentheses ),
     * the plus + or minus sign -, non-negative integers and empty spaces .
     * 实现基本计算简单的表达式，表达式支持括号、加号、减号、非负整数、空格
     * Example 1:
     * Input: "1 + 1"
     * Output: 2
     *
     * Example 2:
     * Input: " 2-1 + 2 "
     * Output: 3
     *
     * Example 3:
     * Input: "(1+(4+5+2)-3)+(6+8)"
     * Output: 23
     * Note:
     * You may assume that the given expression is always valid.
     * Do not use the eval built-in library function.
     * 假定给定表达式有效
     * 不要使用库函数
     *
     * 算法：
     * 使用栈来实现模拟计算
     * 左括号     入栈
     * 右括号     出栈直到遇到左括号
     * 加号、减号  入栈
     * 非负整数   栈有元素时获取栈顶元素，如为加减号进行计算后入栈
     * 空格      忽略处理下一个
     *
     * 未通过用例：
     * "2147483647"
     * 原因：需要持续计算整数值
     *
     * todo  coding  and learning
     * */
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            switch (cur) {
                case ' ':
                    break;
                case '(':
                    stack.push(cur + "");
                    break;
                case ')':
                    dealWithRightChar(stack);
                    break;
                case '-':
                    stack.push(cur + "");
                    break;
                case '+':
                    stack.push(cur + "");
                    break;
                default:
                    dealWithInteger(stack, cur - '0');
            }
        }
        return stack.isEmpty() ? 0 : Integer.valueOf(stack.peek());
    }

    private void dealWithRightChar(Deque<String> stack) {
        int val = Integer.valueOf(stack.pop());
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if (cur.equals("(")) {
                dealWithInteger(stack, val);
                return;
            }
            if (cur.equals("+")) {
                val += Integer.valueOf(stack.pop());
                continue;
            }
            if (cur.equals("-")) {
                val = Integer.valueOf(stack.pop()) - val;
            }
        }
    }

    private void dealWithInteger(Deque<String> stack, int val) {
        while (!stack.isEmpty()) {
            String peek = stack.peek();
            if (peek.equals("(")){
                break;
            }
            stack.pop();
            if (peek.equals("+")) {
                val += Integer.valueOf(stack.pop());
                continue;
            }
            if (peek.equals("-")) {
                val = Integer.valueOf(stack.pop()) - val;
                continue;
            }
        }
        stack.push(val + "");
    }


    public static void main(String[] args) {
        int calculate = new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(calculate);
    }

}
