package code.code_151_200.code_187;

import java.util.*;

public class RepeatedDNASequences {

    /*
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
     * for example: "ACGAATTCCG". When studying DNA,
     * it is sometimes useful to identify repeated sequences within the DNA.
     *
     * Write a function to find all the 10-letter-long sequences (substrings)
     * that occur more than once in a DNA molecule.
     * 目标：查找所有长度为10 且出现超过一次的连续子串
     *
     * Example:
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
     *
     * 算法：
     * 1 暴力
     *   时间复杂度 O(n^2) 重复计算体现在 对之后的串 判断是否包含子串时，重复处理
     * 2 优化暴力
     *   缓存 后面的所有子串 并在处理完当前后 删除 之后无效的子串
     *   时间复杂度 O(N) 空间复杂度 O(N^2) 典型的空间换时间
     *
     * 未通过示例："AAAAAAAAAAA"
     * 期望输出："AAAAAAAAAA"
     * 未通过原因：题意理解问题，以为当前串中的 字符不可重复使用
     * 解决：cache 从1 开始加入  移除从下一个位置开始移除
     *
     * todo 1 对空间复杂度的优化  使用二进制的数取代字符串 减少空间消耗 2 无需先存入cache 可以边处理边存入cache 注意去重
     * https://leetcode.wang/leetcode-187-Repeated-DNA-Sequences.html 方法②
     * */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 11) {
            return res;
        }
        Map<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String cur = s.substring(i, i + 10);
            Integer count = cache.get(cur);
            if (count == null) {
                cache.put(cur, 1);
            } else {
                cache.put(cur, count + 1);
            }
        }
        int begin = 0;
        while (begin < s.length() - 10) {
            String cur = s.substring(begin, begin + 10);
            Integer integer = cache.get(cur);
            if (integer != null) {
                if (integer > 1) {
                    res.add(cur);
                }
                // 防止结果存重复串
                cache.remove(cur);
            }
            begin++;
        }
        return res;
    }

    public static void main(String[] args) {
        findRepeatedDnaSequences2("AAAAAAAAAAA");
    }

    public static List<String> findRepeatedDnaSequences2(String s) {
        if (s == null || s.length() < 11) {
            return new ArrayList<>();
        }
        Set<String> cache = new HashSet<>();
        Set<String> res = new HashSet<>();
        int begin = 0;
        while (begin < s.length() - 9) {
            String cur = s.substring(begin, begin + 10);
            if (cache.contains(cur)){
                res.add(cur);
            }else {
                cache.add(cur);
            }
            begin++;
        }
        return new ArrayList<>(res);
    }
}
