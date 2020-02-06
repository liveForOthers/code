package code.code_201_250.code_212;

import javax.xml.ws.WebServiceRefs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    /*
     * Given a 2D board and a list of words from the dictionary, find all words in the board.
     * 给定平面矩阵 和字典单词的列表，找出在矩阵中的所有单词
     * Each word must be constructed from letters of sequentially adjacent cell,
     * where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once in a word.
     * 每个单词  必须由水平或垂直相邻的字母组成
     * 相同的字母只能使用一次
     * Example:
     * Input:
     * board =
     * [['o','a','a','n'],
     *  ['e','t','a','e'],
     *  ['i','h','k','r'],
     *  ['i','f','l','v']]
     *  words = ["oath","pea","eat","rain"]
     *  Output: ["eat","oath"]
     *
     *  Note:
     *  All inputs are consist of lowercase letters a-z.
     *  所有单词由小写字母组成
     *  The values of words are distinct.
     *  单词不重复
     *
     *  算法：
     *  1 对每个单词在矩阵中执行bfs搜索 最坏请款下需遍历 m*((n^2)!)次  其中m是单词个数  n是矩阵一个边元素数目
     *  2 将矩阵可构成的所有单词都存入前缀树中 需处理 ((n^2)!)次 然后遍历单词列表进行搜索 比1减少了m倍的时间消耗
     *
     *  todo  以上两种方法都要遍历 ((n^2)!)次 其中1可以进行剪枝  2完全不能剪枝  效率并不高
     *  todo  学习：尝试仅处理 ((n^2)!)次 且可以剪枝
     *  todo  将单词列表存入前缀树中，处理矩阵时 根据当前词是否是前缀树前缀进行剪枝
     *
     *  todo 未通过样本：[["a","a"]]  ["aaa"]
     *  未通过原因： 同一个字符多次使用没有进行标记
     *
     * */
    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        Trie trie = new Trie();
        for (String cur : words) {
            trie.addWord(cur);
        }
        Set<String> res = new HashSet<>();
        StringBuilder cur = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        P:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //执行bfs
                bfs(board, i, j, trie.getRoot(), res, cur, visited);
                if (res.size() == words.length) {
                    break P;
                }
            }
        }
        return new ArrayList<>(res);
    }

    private void bfs(char[][] board, int i, int j, TrieNode parentNode, Set<String> res, StringBuilder cur, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (parentNode.getCache()[board[i][j] - 'a'] == null) {
            //此i,j 无效
            return;
        }
        cur.append(board[i][j]);
        visited[i][j] = true;
        if (parentNode.getCache()[board[i][j] - 'a'].isEndNode()) {
            // 有效单词 加入到结果中
            res.add(cur.toString());
            // 继续扫描 后继单词
        }
        bfs(board, i - 1, j, parentNode.getCache()[board[i][j] - 'a'], res, cur, visited);
        bfs(board, i + 1, j, parentNode.getCache()[board[i][j] - 'a'], res, cur, visited);
        bfs(board, i, j - 1, parentNode.getCache()[board[i][j] - 'a'], res, cur, visited);
        bfs(board, i, j + 1, parentNode.getCache()[board[i][j] - 'a'], res, cur, visited);
        cur.deleteCharAt(cur.length() - 1);
        visited[i][j] = false;
    }


    class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        private void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode trieNode = node.cache[word.charAt(i) - 'a'];
                if (trieNode == null) {
                    trieNode = new TrieNode();
                    node.cache[word.charAt(i) - 'a'] = trieNode;
                }
                node = trieNode;
            }
            node.setEndNode(true);
        }

        public TrieNode getRoot() {
            return root;
        }
    }

    class TrieNode {
        private boolean isEndNode = false;
        private TrieNode[] cache = new TrieNode[26];

        public boolean isEndNode() {
            return isEndNode;
        }

        public void setEndNode(boolean endNode) {
            isEndNode = endNode;
        }

        public TrieNode[] getCache() {
            return cache;
        }

        public void setCache(TrieNode[] cache) {
            this.cache = cache;
        }
    }

    public static void main(String[] args) {
        List<String> words = new WordSearchII().findWords(new char[][]{{'a', 'a'}}, new String[]{"aaa"});
        System.out.println(words);
    }
}
