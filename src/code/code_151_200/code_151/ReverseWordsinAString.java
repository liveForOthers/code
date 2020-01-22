package code.code_151_200.code_151;

public class ReverseWordsinAString {

    /*
     * Given an input string, reverse the string word by word.
     * 给定传 一个单词一个单词的反转
     * Example 1:
     * Input: "the sky is blue"
     * Output: "blue is sky the"
     *
     * Example 2:
     * Input: "  hello world!  "
     * Output: "world! hello"
     * 去掉多余空格，标点符号跟着前词一起
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     * 首尾不可有空格
     * Example 3:
     * Input: "a good   example"
     * Output: "example good a"
     *
     * Explanation: You need to reduce multiple spaces
     * between two words to a single space in the reversed strin
     * 两个单词间只可有一个空格
     *
     * 算法：从后向前处理，遇到空格结束
     * */
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int begin = s.length() - 1;
        while (begin >= 0) {
            int end = begin;
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            begin = end;
            while (begin >= 0 && s.charAt(begin) != ' ') {
                begin--;
            }
            if (end < 0) {
                break;
            }
            res.append(s.substring(begin + 1, end + 1));
            res.append(' ');
        }
        if (res.length() != 0) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        reverseWords("  hello world!  ");
    }
}
