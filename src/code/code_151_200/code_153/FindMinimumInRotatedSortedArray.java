package code.code_151_200.code_153;

public class FindMinimumInRotatedSortedArray {

    /*
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     *
     * Find the minimum element.
     * You may assume no duplicate exists in the array.
     *
     * Example 1:
     * Input: [3,4,5,1,2]
     * Output: 1
     *
     * Example 2:
     * Input: [4,5,6,7,0,1,2]
     * Output: 0
     * 目标：寻找有序旋转数组中的最小值
     * 算法：
     * 二分法
     *
     * todo 逻辑再看下
     *
     * */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        int left = 0;
        int right = nums.length - 1;
        int res = nums[0];
        while (left <= right) {
            // 取右中位数
            int mid = (left + right + 1) >>> 1;
            res = Math.min(res, nums[mid]);
            if (nums[mid] > nums[left]) {
                // 比较边界 如left大于左边界，左侧有序  否则右侧有序
                //说明mid左侧有序  可以抛弃左侧
                if (nums[left] >= nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // mid的右侧有序
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findMin(new int[]{3, 4, 5, 1, 2});
    }
}
