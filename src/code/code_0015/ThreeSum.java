package code.code_0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*
     * 算法：
     * 1 先排序（从小到大）
     * 2 双指针
     * 3 剪枝优化
     *
     * 本次AC 缺陷：
     * 1  未对cur>0 进行剪枝  导致后面无意义的计算
     * 2  未考虑 当前命中时 指针滑动进行滑动前后值相等进行去重
     *
     * */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null && nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int cur = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curSum = cur + nums[left] + nums[right];
                if (curSum < 0) {
                    left++;
                } else if (curSum > 0) {
                    right--;
                } else {
                    List<Integer> curRes = new ArrayList<>();
                    curRes.add(cur);
                    curRes.add(nums[left]);
                    curRes.add(nums[right]);
                    res.add(curRes);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
