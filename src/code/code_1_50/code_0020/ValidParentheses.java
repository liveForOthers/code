package code.code_1_50.code_0020;

import java.util.LinkedList;

public class ValidParentheses {

    /*
    *  主要是栈数据结构的应用
    * */
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cur = routing(c);
            if (cur > 0) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Integer pop = stack.pop();
                if (pop + cur == 0) {
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }

    private int routing(char c) {
        switch (c) {
            case '(':
                return 1;
            case '[':
                return 2;
            case '{':
                return 3;
            case ')':
                return -1;
            case ']':
                return -2;
            case '}':
                return -3;
            default:
                throw new IllegalArgumentException("参数异常");
        }
    }
}
