package code.code_1_50.code_0034;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /*
     * 举个栗子： Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
     *
     * 找到 最左 最右面 的下表的位置
     * 初始思路： 二分法 找到目标值位置
     * 记录 并继续 左右找 直到找不到以上次记录值为结果
     *
     * */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = dichotomy(-1,nums,target);
        res[1] = dichotomy(1,nums,target);
        return res;
    }

    /*
     *  findMode = -1  找最左侧下标位置
     *           = 1   找最右侧下标位置
     *           = 0   正常查找 命中返回
     * */
    private int dichotomy(int findMode, int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int prevIndex = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                if (findMode == 0) {
                    return mid;
                } else if (findMode == -1) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                prevIndex = mid;
            } else if (nums[mid] > target) {
                // 快速失败
                if (nums[left] > target) {
                    return prevIndex;
                }
                right = mid - 1;
            } else {
                // 快速失败
                if (nums[right] < target) {
                    return prevIndex;
                }
                left = mid + 1;
            }
        }
        return prevIndex;
    }
}
