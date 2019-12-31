package code.code_51_100.code_0078;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: nums = [1,2,3]
     *
     * Output:
     * [[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
     *
     * 目标：
     * 找出数组的所有子数组  包含数组本身 以及 空数组
     *
     * 算法：
     * 深度优先搜索+回溯
     *
     * */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 1; i <= nums.length; i++) {
            dfs(nums, res, new ArrayList<>(), i, 0, 0);
        }
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int sum, int count, int start) {
        if (count == sum) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, res, cur, sum, count + 1, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
