package code.code_0044;

public class WildcardMatching1 {

    public static void main(String[] args) {
        isMatch("acdcb"
                ,"a*c?b");
    }

    /*
     *  '?' Matches any single character.
     *  '*' Matches any sequence of characters (including the empty sequence)
     *
     *  s could be empty and contains only lowercase letters a-z.
     *  p could be empty and contains only lowercase letters a-z, and characters like ? or *.
     *
     *  当'*' 多时 递归深度过深  时间复杂度高  已超时
     *
     * */
    public static boolean isMatch(String s, String p) {
        if (s == p) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        return doMatch(s, p, 0, 0);
    }

    private static boolean doMatch(String s, String p, int sIndex, int pIndex) {
        // 串s遍历完毕 判断 串p遍历完毕 或 p之后的字符皆为*
        if (sIndex == s.length()) {
            return pIndex == p.length() ||
                    (p.charAt(pIndex) == '*' && doMatch(s, p, sIndex, pIndex + 1));
        }
        // 串p 遍历完毕 但 串s 未遍历完毕 返回不匹配
        if (pIndex == p.length()) {
            return false;
        }
        // 当前位置匹配 处理下一个位置
        if (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex)) {
            return doMatch(s, p, sIndex + 1, pIndex + 1);
        }
        // 不匹配 且 p当前字符不为 '*' 返回失败
        if (p.charAt(pIndex) != '*') {
            return false;
        }
        // 这里只能依靠* 来遍历递归处理  直到判定相等  否则返回 不相等
        // 因为 * 可以匹配 0到max 个字符的串  所以需要 遍历0到max 依次尝试  都失败 才失败
        // i 为 '*' 匹配的 从 sIndex 开始 的长度
        for (int i = 0; i <= s.length() - sIndex; i++) {
            if (doMatch(s, p, sIndex + i, pIndex + 1)) {
                return true;
            }
        }
        return false;
    }


}
