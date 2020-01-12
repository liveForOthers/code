package code.code_101_150.code_131;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /*
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return all possible palindrome partitioning of s.
     *
     * Example:
     *
     * Input: "aab"
     * Output:
     * [["aa","b"],
     * ["a","a","b"]]
     *
     * 目标：给定串，将其分割，使每个子串都是回文串，返回所有可能得回文子串组合
     *
     * 算法：
     * 所有结果 想到使用回溯法
     * 缓存回文串段 避免每次都要重复判断每段是否为回文串
     *
     * */
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i - 1]);
            }
        }
        dfs(res, new ArrayList<String>(), dp, s, 0, 1);
        return res;
    }

    private static void dfs(List<List<String>> res,
                     List<String> cur,
                     boolean[][] dp,
                     String s,
                     int left,
                     int right) {
        if (left >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = right; i <= s.length(); i++) {
            if (!dp[left][i - 1]) {
                continue;
            }
            cur.add(s.substring(left, i));
            dfs(res, cur, dp, s, i, i + 1);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        partition("aab");
    }
}
