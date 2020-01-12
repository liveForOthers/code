package code.code_101_150.code_132;

public class PalindromePartitioningII {

    /*
    * Given a string s, partition s such that every substring of the partition is a palindrome.
    * Return the minimum cuts needed for a palindrome partitioning of s.
    *
    * Example:
    *
    * Input: "aab"
    * Output: 1
    * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
    *
    * 目标：给定串，将串分割使每个子串为回文串，求分割最小的次数
    *
    * 算法：
    * 学习：花花酱：https://www.bilibili.com/video/av78461289?from=search&seid=18144975048354189754
    *
    * dp[i] 表示 从0到i 串分割为回文子串最小分割次数
    *
    * dp[i] = min(dp[i],dp[j]+1) 如果j到i间的串构成回文串
    *
    * valid[i][j] 表示i到j间的子串是否为回文串
    * valid[i][j] = c[i]==c[j] && (j-i<3 || valid[i+1][j-1])
    *
    * todo: 待coding
    *
    * */
    public int minCut(String s) {
        throw new IllegalArgumentException("待coding");
    }
}
