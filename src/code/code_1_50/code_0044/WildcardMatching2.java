package code.code_1_50.code_0044;

public class WildcardMatching2 {

    public static void main(String[] args) {
        isMatch("acdcb"
                , "a*c?b");
    }

    /*
     *  '?' Matches any single character.
     *  '*' Matches any sequence of characters (including the empty sequence)
     *
     *  s could be empty and contains only lowercase letters a-z.
     *  p could be empty and contains only lowercase letters a-z, and characters like ? or *.
     *
     *  当'*' 多时 递归深度过深  时间复杂度高  递归已超时
     *
     *  采用双指针迭代方式取代递归 当出现'*' 时可能需要 双指针回退操作 时间复杂度 O(M*N)
     *
     *  对于 *B*  这种情况  只要*B 与s某段匹配了 那么认为*B 完全覆盖s该段  直接处理 *B 之后 与 s该段之后 进行匹配处理即可
     *
     *  如 *B*12312321312
     *  vs ASDASDAS B 34U2 B 4395849
     *  *B 匹配了 ASDASDAS B 后面的 * 可以覆盖 匹配 ASDASDAS B 34U2 B 的情况  只要针对后面的* 作为当前* 处理即可
     *  而无需 前面的* 再依次 后退指针处理
     *
     *  1 如匹配 两指针++
     *  2 如不匹配 且为 '*' 更新 '*' 下标 用于回溯 p指针++ 保存当前s指针 用于回溯
     *  3 如不匹配 且不为'*' 回退指针 p回退到 '*' 下标 下一个位置 保存当前s指针加1  s回退到 保存当前s指针位置
     *  4 不可回退 返回失败
     *
     * */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return s == null && p == null;
        }
        if (s.equals(p)) {
            return true;
        }
        return doMatch(s, p);
    }

    private static boolean doMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int sMatch = 0;
        int prev = -1;

        while (sIndex < s.length()) {
            // 当前位置匹配 处理下一个位置
            if (pIndex < p.length() && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))) {
                sIndex++;
                pIndex++;
                continue;
            }
            if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                prev = pIndex;
                pIndex++;
                sMatch = sIndex;
                continue;
            }
            // 之前有'*' 可以回退
            if (prev != -1) {
                sMatch++;
                sIndex = sMatch;
                pIndex = prev + 1;
                continue;
            }
            return false;
        }
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }
        return pIndex == p.length();
    }
}
