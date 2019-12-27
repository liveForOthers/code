package code.code_1_50.code_0018;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[]{1, -1, 0, 0, 2, -2}, 0);
        System.out.println(lists);
    }

    /*
    * fourSum  使用 cache 缓存两数之和 效率并没有明显变好   可能不如直接使用双指针  还能解决去重问题
    * 之后再使用 双指针 加剪枝AC下
    * */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2] + nums[3];
        if (min > target) {
            return res;
        }
        if (min == target) {
            res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return res;
        }
        int max = nums[nums.length - 4] + nums[nums.length - 3]
                + nums[nums.length - 2] + nums[nums.length - 1];
        if (max < target) {
            return res;
        }
        if (max == target) {
            res.add(Arrays.asList(nums[nums.length - 4],
                    nums[nums.length - 3],
                    nums[nums.length - 2],
                    nums[nums.length - 1]));
            return res;
        }
        // 缓存两两之和
        Map<Integer, List<Pair>> cache = new HashMap<>();
        putCache(cache, nums);
        Set<String> dupCache = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curMin = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            if (curMin > target) {
                return res;
            }
            if (curMin == target) {
                res.add(Arrays.asList(nums[i], nums[i+1], nums[i+2], nums[i+3]));
                return res;
            }
            int curMax = nums[i] + nums[nums.length - 3]
                    + nums[nums.length - 2] + nums[nums.length - 1];
            if (curMax < target) {
                continue;
            }
            if (curMax == target) {
                List<Integer> curRes = Arrays.asList(nums[i],
                        nums[nums.length - 3],
                        nums[nums.length - 2],
                        nums[nums.length - 1]);
                String s = curRes.toString();
                if (dupCache.contains(s)) {
                    continue;
                }
                res.add(curRes);
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                List<Pair> pairs = cache.get(target - nums[i] - nums[j]);
                if (pairs == null || pairs.size() == 0) {
                    continue;
                }
                if (j >= pairs.get(pairs.size() - 1).getPrevIndex()) {
                    continue;
                }
                for (Pair pair : pairs) {
                    if (j >= pair.getPrevIndex()) {
                        continue;
                    }
                    List<Integer> curRes = Arrays.asList(nums[i], nums[j], nums[pair.getPrevIndex()], nums[pair.getNextIndex()]);
                    String curResStr = curRes.toString();
                    if (dupCache.contains(curResStr)) {
                        continue;
                    }
                    dupCache.add(curResStr);
                    res.add(curRes);
                }
            }
        }
        return res;
    }

    static class Pair {
        private int prevIndex;
        private int nextIndex;

        Pair(int prevIndex, int nextIndex) {
            this.prevIndex = prevIndex;
            this.nextIndex = nextIndex;
        }

        int getPrevIndex() {
            return prevIndex;
        }

        int getNextIndex() {
            return nextIndex;
        }
    }

    private static void putCache(Map<Integer, List<Pair>> cache, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                List<Pair> pairs = cache.get(sum);
                if (pairs == null) {
                    pairs = new ArrayList<>();
                    cache.put(sum, pairs);
                }
                pairs.add(new Pair(i, j));

            }
        }
    }


}
