package code.code_51_100.code_0077;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    /*
     *
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     *
     * Example:
     *
     * Input: n = 4, k = 2
     *
     * Output:
     * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
     *
     * 目标： 找出 1到n 间  k个数的 无顺序排列
     *
     * 算法：
     * 深度优先搜索+回溯法
     * */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        dfs(n, k, 1, 0, cur, res);
        return res;
    }

    private static void dfs(int n, int k, int start, int count, List<Integer> cur, List<List<Integer>> res) {
        if (k == count) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfs(n, k, i + 1, count + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        combine(4,2);
    }
}
