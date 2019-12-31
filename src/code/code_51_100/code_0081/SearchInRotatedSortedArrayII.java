package code.code_51_100.code_0081;

public class SearchInRotatedSortedArrayII {

    /*
     *
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
     *
     * You are given a target value to search. If found in the array return true, otherwise return false.
     *
     * Example 1:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     *
     * Output: true
     *
     * Example 2:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     *
     * Output: false
     *
     * Follow up:
     * This is a follow up problem to Search in Rotated Sorted Array,
     * where nums may contain duplicates. Would this affect the run-time complexity? How and why?
     *
     * 目标：查找 包含重复元素的有序旋转数组 是否存在指定元素
     *
     * 算法：
     * 之前实现过一次 当复习了
     *
     * */
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] > target) {
                if (nums[mid] > nums[right]) {
                    if (nums[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[mid] < nums[right]) {
                    right = mid - 1;
                } else {
                    right--;
                }
            } else if (nums[mid] < target) {
                if (nums[mid] > nums[left]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[left]) {
                    if (nums[left] > target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    left++;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        search(new int[]{3, 1}, 3);
    }

    /*
    * TODO 分析下
    * 原理都是确定 左右有序性  代码更简洁一些
    * */
    public boolean search2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[i] < nums[mid]) {
                if (nums[i] <= target && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else if (nums[i] > nums[mid]) {
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                i++;
            }
        }
        return false;
    }
}
