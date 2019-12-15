package code.code_0032;

public class LongestValidParenthesesUseTwoPoints {
    /*
     *  使用 left right 双指针 计算 最长 满足为有效括号对的子串 长度
     *
     *  从左往右面遍历一遍
     *  满足 left==right  更新res 长度
     *  如   left< right  left right 置位
     *  对于 left > right 情景  无需更新 结果  会 包括在 从右往左遍历的情况中
     *
     *  从右往左遍历一遍
     *  满足 left==right  更新res 长度
     *  如   left> right  则 left right 置位
     *  对于 right > left 情景  无需更新 结果  会 包括在 从左往右遍历的情况中
     * */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int res = 0;
        // left -> right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
                continue;
            }
            right++;
            if (right > left) {
                left = right = 0;
            } else if (right == left) {
                res = Math.max(res, left << 1);
            }
        }

        left = right = 0;
        // right -> left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
                continue;
            }
            left++;
            if (left > right) {
                left = right = 0;
            } else if (left == right) {
                res = Math.max(res, right << 1);
            }
        }
        return res;
    }
}
