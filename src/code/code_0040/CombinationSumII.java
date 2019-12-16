package code.code_0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /*
    *  回溯 深度优先搜索   有重复元素  一个元素仅可使用一次  去重
    * */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        if (target < candidates[0]) {
            return res;
        }
        dfs(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] candidates, int curIndex, int left, List<Integer> curList, List<List<Integer>> res) {
        if (left == 0) {
            res.add(new ArrayList<Integer>(curList));
            return;
        }

        for (int i = curIndex; i < candidates.length; i++) {
            if (i != curIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (left < candidates[i]) {
                return;
            }
            curList.add(candidates[i]);
            dfs(candidates, i + 1, left - candidates[i], curList, res);
            curList.remove(curList.size() - 1);
        }
    }
}
