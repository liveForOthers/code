package code.code_1_50.code_0017;


import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }
    /*
    *  该算法 回溯法入门
    *
    * */
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] cache = new String[]{"", "", "abc", "def",
                "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, cache, 0, res, new StringBuilder());
        return res;
    }

    private static void dfs(String digits,
                     String[] cache,
                     int curIndex,
                     List<String> res,
                     StringBuilder stringBuilder) {
        if (curIndex >= digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        char c = digits.charAt(curIndex);
        if (!isLegalDigit(c)) {
            throw new IllegalArgumentException("参数异常");
        }
        String cacheString = cache[c - '0'];
        for (int j = 0; j < cacheString.length(); j++) {
            char ch = cacheString.charAt(j);
            stringBuilder.append(ch);
            dfs(digits, cache, curIndex+1, res, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    private static boolean isLegalDigit(char c) {
        return c <= '9' && c >= '2';
    }
}
