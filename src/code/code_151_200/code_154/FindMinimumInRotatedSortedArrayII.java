package code.code_151_200.code_154;

public class FindMinimumInRotatedSortedArrayII {


    /*
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     *
     * Find the minimum element.
     * The array may contain duplicates.
     * 可能存在重复的元素
     * Example 1:
     * Input: [1,3,5]
     * Output: 1
     *
     * Example 2:
     * Input: [2,2,2,0,1]
     * Output: 0
     *
     * 寻找出数组中最小值
     * */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        int res = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            res = Math.min(res, nums[mid]);
            if (nums[mid] > nums[left]) {
                if (nums[left] >= nums[0]) {
                    //mid左侧有序
                    left = mid + 1;
                } else {
                    //mid 右侧有序
                    right = mid - 1;
                }
            } else if (nums[mid] < nums[left]) {
                //mid右侧有序
                right = mid - 1;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findMin(new int[]{1,3,5});
    }
}
