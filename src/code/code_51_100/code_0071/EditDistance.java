package code.code_51_100.code_0071;

public class EditDistance {

    /*
     * Given two words word1 and word2, find the minimum number of operations
     * required to convert word1 to word2.
     * You have the following 3 operations permitted on a word:
     * 1 Insert a character
     * 2 Delete a character
     * 3 Replace a character
     *
     * Example 1:
     * Input: word1 = "horse", word2 = "ros"  Output: 3
     *
     * Explanation:
     *   horse -> rorse (replace 'h' with 'r')
     *   rorse -> rose (remove 'r')
     *   rose -> ros (remove 'e')
     *
     * Example 2:
     * Input: word1 = "intention", word2 = "execution"
     * Output: 5
     *
     * Explanation:
     *   intention -> inention (remove 't')
     *   inention -> enention (replace 'i' with 'e')
     *   enention -> exention (replace 'n' with 'x')
     *   exention -> exection (replace 'n' with 'c')
     *   exection -> execution (insert 'u')
     *
     * 动态规划：
     * dp[i][j] 表示 串s 前i个序列 转为 target 前j个序列 的最小边界距离
     *
     * 迭代表达式：
     * if (s(i)==t(j))  则 dp[i][j] = dp[i-1][j-1],
     * else                dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + 1
     *
     * 吃一堑：
     *
     * 算法想到了，但是对于动态规划缓存边界没考虑清楚
     * 1 字符串字符下标范围为 0~length()-1
     *   但是缓存 边界包含了 0个字符的含义  所以下标范围为 0~length()
     *
     * */
    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word2 == null) {
            return word1 == null ? word2.length() : word1.length();
        }
        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() == 0 ? word2.length() : word1.length();
        }
        // 二维动态规划  之后 使用滚动数组优化
        int[][] cache = new int[word1.length() + 1][word2.length() + 1];
        // 初始化
        for (int i = 1; i <= word1.length(); i++) {
            cache[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            cache[0][j] = j;
        }
        // 根据已知求未知
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1];
                    continue;
                }
                cache[i][j] = 1 + Math.min(Math.min(cache[i - 1][j], cache[i][j - 1]), cache[i - 1][j - 1]);
            }
        }
        return cache[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        minDistance2("horse", "ros");
    }

    /*
     * 滚动数组优化
     *
     * 注意点：
     * 1 cache[0] 初始节点 要在下一代遍历时变化
     * 2 存储左上角元素 每次遍历 迭代更新
     *
     * */
    public static int minDistance2(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word2 == null) {
            return word1 == null ? word2.length() : word1.length();
        }
        // 二维动态规划  之后 使用滚动数组优化
        int[] cache = new int[word2.length() + 1];
        // 初始化
        for (int j = 1; j <= word2.length(); j++) {
            cache[j] = j;
        }
        // 根据已知求未知
        for (int i = 1; i <= word1.length(); i++) {
            cache[0] = i;
            // 左上角元素
            int prev = i - 1;
            for (int j = 1; j <= word2.length(); j++) {
                int temp = cache[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cache[j] = prev;
                } else {
                    cache[j] = 1 + Math.min(Math.min(cache[j], cache[j - 1]), prev);
                }
                prev = temp;
            }
        }
        return cache[word2.length()];
    }
}
