package code.code_201_250.code_208;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    /**
     * Initialize your data structure here.
     */
    /*
     * Implement a trie with insert, search, and startsWith methods.
     * 实现一种存储结构 可提供  插入、全量查询、前缀查询 功能
     * Example:
     * Trie trie = new Trie();
     * trie.insert("apple");
     * trie.search("apple");   // returns true
     * trie.search("app");     // returns false
     * trie.startsWith("app"); // returns true
     * trie.insert("app");
     * trie.search("app");     // returns true
     *
     * Note:
     * You may assume that all inputs are consist of lowercase letters a-z.
     * All inputs are guaranteed to be non-empty strings.
     * 所有输入都是小写英文字符
     *
     * todo 1 前缀树算法理解(What Why When How)  2 code bug free 3 只为小写英文字符 场景可以使用数组取代map 提高速度
     * */
    public Trie() {
        root = new TrieNode(false);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        // 遍历串中每一个字符
        for (int i = 0; i < word.length(); i++) {
            // 查询当前节点 子节点是否包含当前字符
            TrieNode trieNode = node.getCache().get(word.charAt(i));
            // 不存在的处理方式 创建节点
            if (trieNode == null) {
                trieNode = new TrieNode(false);
                node.getCache().put(word.charAt(i), trieNode);
            }
            // 更新当前节点。进行下一个处理
            node = trieNode;
        }
        node.setEndNode(true);
    }

    /**
     * 如存在返回prefix串的最后一个节点，否则返回null
     */
    public TrieNode searchPrefix(String prefix) {
        // 初始化当前节点
        TrieNode node = root;
        // 遍历前缀串
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = node.getCache().get(prefix.charAt(i));
            // 判断当前字符是否是当前节点的子节点
            if (next == null) {
                // 不是，返回 null
                return null;
            }
            // 是，更新当前节点 继续后面搜索
            node = next;
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode trieNode = searchPrefix(word);
        return trieNode != null && trieNode.isEndNode();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode root;

    class TrieNode {
        private boolean isEndNode;
        private Map<Character, TrieNode> cache;

        public TrieNode(boolean isEndNode) {
            this.isEndNode = isEndNode;
            cache = new HashMap<>();
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
        Trie trie = new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");
        System.out.println(apple);
    }
}
