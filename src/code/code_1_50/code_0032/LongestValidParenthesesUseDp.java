package code.code_1_50.code_0032;

public class LongestValidParenthesesUseDp {
    /*
     *  本题意 目的是找连续子串中 最长的 有效 括号对 字符数
     *  共三种高效算法 本示例展示 动态规划算法
     *  dp[i] 记录 以 char[i] 为终止符号 的 之前的最长 有效括号对 字符数
     *      char[i] 如为'(' 则直接设置为0
     *              如为')' 且 char[i-1] 为'(' 则更新为 dp[i-2]+2
     *                     且 char[i-1] 为')' 则
     *                            如果char[i-dp[i-1]-1] 为 '(' 则更新为 dp[i-1] + dp[i-dp[i-2]-2] +2
     *                                                 为 ')' 则更新为 0
     * */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            if (s.charAt(i - 1) == '(') {
                dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                res = Math.max(res, dp[i]);
                continue;
            }
            if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + 2 + ((i - 2 - dp[i - 1]) >= 0 ? dp[i - dp[i - 1] - 2] : 0);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
