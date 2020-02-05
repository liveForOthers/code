package code.code_201_250.code_211;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    /**
     * Initialize your data structure here.
     */
    /*
     * Design a data structure that supports the following two operations:
     *
     * void addWord(word)
     * bool search(word)
     * search(word) can search a literal word or a regular expression string
     * containing only letters a-z or .. A . means it can represent any one letter.
     *
     * 增加和查询达到O(1)时间复杂度 使用LRU算法即可  但是本题要实现正则查询
     *
     * Example:
     * addWord("bad")
     * addWord("dad")
     * addWord("mad")
     * search("pad") -> false
     * search("bad") -> true
     * search(".ad") -> true
     * search("b..") -> true
     * Note:
     * You may assume that all words are consist of lowercase letters a-z.
     *
     * 算法:
     * 使用前缀树  并扩展 '.'匹配一个字符的模糊搜索
     *
     * todo  使用set缓存  并以长度进行区分  对不同长度存入不同set来减少模糊搜索暴力搜索单词数目的方法值得借鉴
     * */
    public WordDictionary() {
        this.root = new TrieNode(false);
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode trieNode = node.getCache().get(word.charAt(i));
            if (trieNode == null) {
                trieNode = new TrieNode(false);
                node.getCache().put(word.charAt(i), trieNode);
            }
            node = trieNode;
        }
        node.setEndNode(true);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return doSearch(root, word, 0) != null;
    }

    private TrieNode doSearch(TrieNode curNode, String word, int index) {
        TrieNode node = curNode;
        for (int i = index; i < word.length(); i++) {
            Map<Character, TrieNode> cache = node.getCache();
            if (word.charAt(i) == '.') {
                // 对cache中的每个value 进行查找
                for (Map.Entry<Character, TrieNode> entry : cache.entrySet()) {
                    if (entry == null || entry.getValue() == null) {
                        continue;
                    }
                    TrieNode trieNode = doSearch(entry.getValue(), word, i + 1);
                    if (trieNode != null && trieNode.isEndNode) {
                        return trieNode;
                    }
                }
                return null;
            }
            TrieNode trieNode = cache.get(word.charAt(i));
            if (trieNode == null) {
                return null;
            }
            node = trieNode;
        }
        return node.isEndNode() ? node : null;
    }


    private TrieNode root;

    class TrieNode {
        private boolean isEndNode;
        private Map<Character, TrieNode> cache;

        public TrieNode(boolean isEndNode) {
            this.isEndNode = isEndNode;
            this.cache = new HashMap<>();
        }

        public boolean isEndNode() {
            return isEndNode;
        }

        public void setEndNode(boolean endNode) {
            isEndNode = endNode;
        }

        public Map<Character, TrieNode> getCache() {
            return cache;
        }

        public void setCache(Map<Character, TrieNode> cache) {
            this.cache = cache;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        boolean search = wordDictionary.search(".a");
        System.out.println(search);

    }
}
