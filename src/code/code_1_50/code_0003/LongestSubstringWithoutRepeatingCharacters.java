package code.code_1_50.code_0003;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
     * 1 用数组cache 存储 当前有效的字符的索引+1(+1 是为了与0 进行区分)
     *   数组cache 比Map 效率更高
     * 2 发现重复字符后 要清除 重复字符之前的所有字符的cache
     * */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] cache = new int[256];
        int res = 0;
        int headIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            //未出现重复字符的处理
            if (cache[cur] == 0) {
                cache[cur] = i + 1;
                continue;
            }
            //出现重复字符的处理
            res = Math.max(i - headIndex, res);
            doClear(s, cache, headIndex, cache[cur] - 1);
            headIndex = cache[cur];
            cache[cur] = i + 1;
        }
        res = Math.max(s.length() - headIndex, res);
        return res;
    }

    private void doClear(String s, int[] cache, int headIndex, int endIndex) {
        for (int i = headIndex; i < endIndex; i++) {
            cache[s.charAt(i)] = 0;
        }
    }
}
