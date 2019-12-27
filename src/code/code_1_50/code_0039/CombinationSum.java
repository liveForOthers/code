package code.code_1_50.code_0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    /*
    *  简单的回溯法  深度优先搜索
    * */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            dfs(candidates, i, left - candidates[i], curList, res);
            curList.remove(curList.size() - 1);
        }
    }
}
