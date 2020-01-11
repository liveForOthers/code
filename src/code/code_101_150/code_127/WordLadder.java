package code.code_101_150.code_127;

import java.util.List;

public class WordLadder {

    /*
     * Given two words (beginWord and endWord), and a dictionary's word list,
     * find the length of shortest transformation sequence from beginWord to endWord, such that:
     *
     * Only one letter can be changed at a time.
     *
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     *
     * Note:
     *
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     *
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     *
     * 目标：
     * 给定 开始串 以及结束串 以及一个词集合
     * 找到 从开始串 到结束串 到最短转换序列长度
     * 满足以下条件：
     * 1 一次仅能改变一个单词
     * 2 转换的串必须在词集合中
     * 3 开始串不属于转换的串
     * 4 如果无此转换序列返回0
     * 5 所有单词等长
     * 6 所有单词仅包含小写字符
     * 7 词列表中不包含重复串
     * 8 开始串和结束串非空且 不相等
     * 9 结束串必须在词集合中
     *
     * Example 1:
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     *
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * Output: 5
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     *
     * Example 2:
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     *
     * wordList = ["hot","dot","dog","lot","log"]
     * Output: 0
     *
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     *
     * 算法：
     * 暴力法：
     * 回溯算法+缓存
     * 遍历结束串每次字符 对该字符尝试变化 查找词集合中有无此串 有则递归该串  无则变为下一个词 每次更新变换次数
     * 词列表存入map中 使用后移除 回溯时再加入 因此同一个词集合中的串 可能会被遍历对此  因此缓存此串到达开始串的最小变化次数
     *
     * todo 本题目标为找到最小变化次数 使用bfs更好些 找到变更成功的 一个序列则返回该序列次数即可  code
     *
     * 学习：
     * https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode/
     * */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!validateParams(beginWord, endWord, wordList)) {
            return 0;
        }
    }

    private boolean validateParams(String beginWord, String endWord, List<String> wordList) {
        return beginWord != null &&
                beginWord.length() != 0 &&
                endWord != null &&
                endWord.length() == beginWord.length() &&
                wordList != null &&
                wordList.size() != 0;
    }
}
