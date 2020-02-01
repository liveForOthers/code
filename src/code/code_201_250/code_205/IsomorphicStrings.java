package code.code_201_250.code_205;

public class IsomorphicStrings {

    /*
     * Given two strings s and t, determine if they are isomorphic.
     *
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * 判断两个串是否是结构相同的，结构相同指串s中部分字符c全部替换 可得到串t
     *
     * All occurrences of a character must be replaced with another character
     * 一个字符c被替换 全部c都要同步替换 并且要保证顺序不变
     * while preserving the order of characters. No two characters may map to the same character
     * but a character may map to itself.
     *
     * Example 1:
     *
     * Input: s = "egg", t = "add"
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "foo", t = "bar"
     * Output: false
     *
     * Example 3:
     * Input: s = "paper", t = "title"
     * Output: true
     * Note:
     * You may assume both s and t have the same length.
     *
     * 算法：
     * 缓存替换后的字符映射关系 map 优化为使用字符数组进行映射 char[] map = new char[256];
     * 时间复杂度:O(N） 空间复杂度:O(N)
     *
     * 未通过用例:
     * "ab" "aa" false
     * 原因：映射需要双向一一对应
     *
     * todo 通过第三方来建立两两映射关系 耗费空间增大 时间复杂度不变 代码复杂度降低 https://leetcode.wang/leetcode-205-Isomorphic-Strings.html
     * */
    public boolean isIsomorphic(String s, String t) {
        return doIsIsomorphic(s, t) && doIsIsomorphic(t, s);
    }

    public boolean doIsIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] stmap = new char[128];
        for (int i = 0; i < s.length(); i++) {
            char sc = stmap[s.charAt(i)];
            //校验s->t
            //之前已出现过该字符 且映射后不匹配
            if (sc != 0) {
                if (sc != t.charAt(i)) {
                    return false;
                }
            } else {
                //之前未出现过当前字符
                stmap[s.charAt(i)] = t.charAt(i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isomorphic = new IsomorphicStrings().isIsomorphic("ab", "ca");
        System.out.println(isomorphic);
    }

}
