package code.code_201_250.code_216;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    /*
     *
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     * 找到所有可能得k个数和为n的组合
     * 只有1到9可以被使用，且每个组合中数不能重复使用 boolean[] 标记已使用过
     * Note:
     * All numbers will be positive integers.
     * The solution set must not contain duplicate combinations.
     * 所有的数是正整数
     * 不能包含重复结果
     *
     * Example 1:
     *
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     *
     * Example 2:
     *
     * Input: k = 3, n = 9
     * Output: [[1,2,6], [1,3,5], [2,3,4]]
     *
     * 算法：
     * 回溯法+剪枝+已使用数字标记+结果去重
     *
     * */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k < 1 || n < 1) {
            return res;
        }
        dfs(res, k, n, new ArrayList<Integer>(), 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, int count, int sum, List<Integer> cur, int begin) {
        if (count == 0 && sum == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (count == 0 || sum == 0) {
            return;
        }
        for (int i = begin; i <= 9; i++) {
            if (i > sum) {
                return;
            }
            cur.add(i);
            dfs(res, count - 1, sum - i, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> lists = new CombinationSumIII().combinationSum3(3, 7);
        System.out.println(lists);
    }
}
