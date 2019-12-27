package code.code_1_50.code_0022;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        generateParenthesis(3);
    }
    /*
    *  回溯法入门  主机好 dfs 边界变更
    * */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        StringBuilder stringBuilder = new StringBuilder(n << 1);
        dfs(res, stringBuilder, n, 0, 0);
        return res;
    }

    private static void dfs(List<String> res,
                            StringBuilder stringBuilder,
                            int n,
                            int left,
                            int right) {
        if (left == n && right == n) {
            res.add(stringBuilder.toString());
            return;
        }
        if (right < left) {
            stringBuilder.append(')');
            dfs(res, stringBuilder, n, left, right + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (left >= n) {
            return;
        }
        stringBuilder.append('(');
        dfs(res, stringBuilder, n, left + 1, right);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}
