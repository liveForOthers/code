package code.code_1_50.code_0016;

import java.util.Arrays;

public class ThreeSumClosest {
    /*
     * 算法: 双指针 找到 当前index下 距离target最近的 3sum
     *
     * 剪枝优化：
     * 1 左右指针移动的时候，判断前后相等  避免重复计算
     * 2 极值判断  当前index  最小三个数和> target 或 最大两数和+cur <target 则不用再无意义的指针移动
     * 3 当前和==target  直接return  减少后续计算
     *
     * */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("入参异常");
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int cur = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 判断最小值
                int min = cur + nums[left] + nums[left + 1];
                if(target < min){
                    if(Math.abs(target - res) > Math.abs(target - min))
                        res = min;
                    break;
                }
                //判断最大值
                int max = cur + nums[right] + nums[right - 1];
                if(target > max){
                    if(Math.abs(target - res) > Math.abs(target - max))
                        res = max;
                    break;
                }

                int curSum = cur + nums[left] + nums[right];
                if (Math.abs(target - res) > Math.abs(target - curSum)) {
                    res = curSum;
                }
                if (curSum > target) {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (curSum < target) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    return target;
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {

        threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    }
}
