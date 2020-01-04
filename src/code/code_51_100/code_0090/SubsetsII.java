package code.code_51_100.code_0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    /*
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: [1,2,2]
     *
     * Output:
     * [[2],[1],[1,2,2],[2,2],[1,2],[]]
     *
     * 数组中包含重复数字  结果中不可有完全一样的子集合
     *
     * 算法:
     * 1 对数组排序
     * 2 总数为 1，2，3。。。分别dfs
     * 3 当前下标元素与之前下标元素相等 continue 去重
     *
     * */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            dfs(res, new ArrayList<Integer>(), nums, i, 0);
        }
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, int count, int index) {
        if (cur.size() == count) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            dfs(res, cur, nums, count, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsetsWithDup(new int[]{1,2,2});
    }
}
