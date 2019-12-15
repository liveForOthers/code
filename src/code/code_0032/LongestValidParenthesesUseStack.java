package code.code_0032;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParenthesesUseStack {
    /*
     * 使用栈 数据结构 求出 包含有效括号对 最多的 子串 长度
     * 栈中存储 字符为 '(' 的索引下标
     * 如 当前字符为 '('  将当前下标入栈
     *          为 ')' 将栈中字符出栈(出栈'('对应的下标)
     *                获得栈顶元素的index（获得本段子串 第一个'('前一个位置的下标）计算出当前 长度 为 cur = i-index  比较更新 res
     *                栈顶无元素（说明上一段已无效 将本index push入栈 作为后面段 第一个'('的前一个位置下标 ）继续下次遍历
     * */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        // 用于整个串都为有效括号对时的 第一个'(' 前一个位置
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }
            stack.pop();
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            Integer peek = stack.peek();
            res = Math.max(res, i - peek);
        }
        return res;
    }
}
