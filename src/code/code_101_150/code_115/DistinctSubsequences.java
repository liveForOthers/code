package code.code_101_150.code_115;

public class DistinctSubsequences {

    /*
     * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
     *
     * A subsequence of a string is a new string
     * which is formed from the original string by deleting some (can be none) of the characters
     * without disturbing the relative positions of the remaining characters.
     * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
     *
     * Example 1:
     *
     * Input: S = "rabbbit", T = "rabbit"
     *
     * Output: 3
     * Explanation:
     *
     * As shown below, there are 3 ways you can generate "rabbit" from S.
     * (The caret symbol ^ means the chosen letters)
     *
     * rabbbit
     * ^^^^ ^^
     * rabbbit
     * ^^ ^^^^
     * rabbbit
     * ^^^ ^^^
     *
     * 算法：
     * 动态规划+滚动数组优化
     *
     * dp[i][j] 表示 串S前i位 有多少串T前j位 字符串序列
     * 如 s[i]==t[j] 则 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
     * 如 s[i]!=t[j] 则 dp[i][j] = dp[i-1][j]
     *
     * 根据上面递推关系可知 仅依赖 dp[i-1][j-1]以及 dp[i-1][j]  使用滚动数组优化空间复杂度
     *
     * */
    public static int numDistinct(String s, String t) {
        if (t == null || s == null || t.length() == 0 || s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //边界初始化
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        // 根据已知求未知  外循环遍历串s 内循环遍历串t
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i && j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        numDistinct2("babgbag", "bag");

    }

    /*
     * 滚动数组优化
     * 时间复杂度: O(N^2) 空间复杂度: O(N)
     *
     * TODO: A题时 要根据图来 不要想当然  很容易出错  滚动数组再扎实
     * */
    public static int numDistinct2(String s, String t) {
        if (t == null || s == null || t.length() == 0 || s.length() == 0 || s.length() < t.length()) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        //边界初始化
        for (int i = 0; i <= s.length(); i++) {
            dp[i] = 1;
        }
        // 根据已知求未知  外循环遍历串t 内循环遍历串s
        for (int j = 0; j < t.length(); j++) {
            int prev = dp[j];
            int head = 0;
            for (int i = j; i < s.length(); i++) {
                int tmp = dp[i + 1];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1] = prev + head;
                } else {
                    dp[i + 1] = head;
                }
                head = dp[i + 1];
                prev = tmp;
            }
        }
        return dp[s.length()];
    }
}
