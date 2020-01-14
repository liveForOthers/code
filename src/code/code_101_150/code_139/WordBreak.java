package code.code_101_150.code_139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /*
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     * 目标：给定非空串s 以及一个词典 包含一列非空单词，确定是否串s能被分割成空格分割的子串，子串在字典中
     * Note:
     *
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * 同一个字典中的词可使用多次  字典中无重复词
     * You may assume the dictionary does not contain duplicate words.
     *
     * Example 1:
     *
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     *
     * Example 2:
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     *
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     *
     * Note that you are allowed to reuse a dictionary word.
     * Example 3:
     * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output: false
     *
     * 算法：
     * 缓存词典中的词，因为可以保证无重复，用 set缓存即可，使用后再清理掉
     * 指针滑动每一个词，如当前词在词典中，递归滑动后面的，如失败回溯，成功结束
     *
     *未通过的case：
     * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
     * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
     * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
     * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     *
     * 超时了，考虑由长串到短串进行dfs
     *
     * 还是不行
     * 肯定要使用dp优化了
     *
     * */
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> cache = new HashSet<>(wordDict);
        dfs(s, cache, 0);
        return res;
    }

    static boolean res = false;

    private static void dfs(String s, Set<String> cache, int begin) {
        if (res) {
            return;
        }
        if (begin >= s.length()) {
            res = true;
            return;
        }
        for (int i = s.length(); i > begin; i--) {
            String substring = s.substring(begin, i);
            if (cache.contains(substring)) {
                dfs(s, cache, i);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("pen");
        wordBreak2("applepenapple", strings);
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> cache = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && cache.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
