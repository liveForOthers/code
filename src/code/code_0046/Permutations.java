package code.code_0046;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        permute(new int[]{2, 2, 1, 1});
    }

    /*
     * 返回数组的全排列，全部结果
     * 在原题目的基础上 数组中存在重复数的 去重功能
     *
     * 要学习的方法：
     * 1 回溯法 在数组排列中的应用    使用交换法更好的实现回溯
     *   如 1 2 3  使用 first 标识 第first+1位  从 first 到length-1位置的元素选取
     *
     *   如first = 1首元素 选了2  则 将 2 与first进行交换 结果为 2 1 3 下一个first 为first+1 = 2
     *   交换法 实现了  仅需要first之后的元素
     *   不使用交换法 则需要 缓存对应位置的元素是否已被使用  每一位的选择都需要重新遍历已处理的元素  增加了额外的工作
     *
     * 2 去重
     *   如果使用 交换法 在处理 first  也就是选取第 first+1 个元素时
     *   因为使用了交换法，前一个元素可能被交换走了，
     *   去重不能仅仅依赖于前一个元素  还需要检查  first->cur-1 之间所有的元素是否存在与 cur相同的  因此无需进行排序
     *
     *   如不使用交换法
     *   0 需要对数组进行排序
     *   1 在缓存对应位置的元素是否已被使用的基础上
     *   2 只需要比较当前元素和前一个元素是否相等即可
     * */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<>();
        for (int cur : nums) {
            numList.add(cur);
        }
        dfs(res, numList, 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> numList, int first) {
        if (first == numList.size()) {
            List<Integer> cur = new ArrayList<>(numList);
            res.add(cur);
            return;
        }
        for (int i = first; i < numList.size(); i++) {
            if (i > first && numList.get(i).equals(numList.get(first))) {
                continue;
            }
            swap(numList, first, i);
            dfs(res, numList, first + 1);
            swap(numList, i, first);
        }
    }

    private static void swap(List<Integer> numList, int i, int j) {
        int tmp = numList.get(i);
        numList.set(i, numList.get(j));
        numList.set(j, tmp);
    }

    private static boolean isUsed(List<Integer> numList, int i, int j) {
        for (int x = i; x < j; x++) {
            if (numList.get(x).equals(numList.get(j))) {
                return true;
            }
        }
        return false;
    }
}
