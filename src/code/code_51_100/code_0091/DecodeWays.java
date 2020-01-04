package code.code_51_100.code_0091;

public class DecodeWays {

    /*
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     *
     * Given a non-empty string containing only digits, determine the total number of ways to decode it.
     *
     * Example 1:
     *
     * Input: "12"
     * Output: 2
     * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     *
     * Example 2:
     *
     * Input: "226"
     * Output: 3
     * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     *
     * 目标：
     * 将数字转码成对应的英文字符，返回可转成的不同串个数
     *
     * 算法：
     * 由映射规则 可知道
     * 第i位及之后字符可转换的个数 由 第 i+1 位以及第 i+2 位及之后的字符共同决定
     *
     * 如果第i位数字为0 dp[i] = 0
     * 如第i位以及第i+1位组成数字<=26 则dp[i] = dp[i+1]+dp[i+2]
     * 否则 dp[i] = dp[i+1]
     *
     * 对于"00""30""x0" 情况特殊标记 返回0 无法转码
     * 时间复杂度：O(N)  空间复杂度：O(N)
     *
     * 学习：
     * 1 空间复杂度还可以继续优化
     *   dp[i] = dp[i + 1] + dp[i + 2];
     *   使用滚动数 将空间复杂度优化到O(1)
     * 2 初始值设定选取好 如：
     *   dp[s.length()] = 1;
     *
     *   编程时使用极值法进行验证初始值是否选取正确
     * TODO：DecodeWays coding
     * */
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        boolean prevZero = false;
        if (s.charAt(s.length() - 1) == '0') {
            prevZero = true;
        } else if (s.charAt(s.length() - 1) <= '9' && s.charAt(s.length() - 1) >= '1') {
            dp[s.length() - 1] = 1;
        } else {
            return 0;
        }
        dp[s.length()] = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return 0;
            }
            if (prevZero && (s.charAt(i) != '1' && s.charAt(i) != '2')) {
                return 0;
            }
            if (s.charAt(i) == '0') {
                prevZero = true;
                continue;
            }
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
            prevZero = false;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        numDecodings("12");
    }
}
