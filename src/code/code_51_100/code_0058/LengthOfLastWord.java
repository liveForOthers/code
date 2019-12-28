package code.code_51_100.code_0058;

public class LengthOfLastWord {

    /*
     * easy
     * Input: "Hello World" Output: 5
     *
     * 返回最后一个单词长度  单词定义：不包含空格
     * 倒着遍历即可
     *
     * */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int endIndex = i;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return endIndex - i;
            }
        }
        return endIndex - i;
    }
}
