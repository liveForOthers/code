package code.code_151_200.code_162;

public class FindPeakElement {
    /*
     * A peak element is an element that is greater than its neighbors.
     * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * You may imagine that nums[-1] = nums[n] = -∞.
     *
     * Example 1:
     * Input: nums = [1,2,3,1]
     * Output: 2
     * Explanation: 3 is a peak element and your function should return the index number 2.
     *
     * Example 2:
     * Input: nums = [1,2,1,3,5,6,4]
     * Output: 1 or 5
     * Explanation: Your function can return either index number 1 where the peak element is 2,
     * or index number 5 where the peak element is 6.
     *
     * Note:
     * Your solution should be in logarithmic complexity.
     *
     * logN 时间复杂度 找出峰值元素下标
     *
     * todo 学习：https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode/
     *
     * 算法等价于 找趋势上升端，某一端到某点能保证上升，则该侧必有峰值点
     * 如左右边界都不能保证上升则校验该店是否为峰值，不是则随意抛弃一侧，令一侧必有峰值
     *
     * */
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[left]) {
                right = mid - 1;
                continue;
            }
            if (nums[mid] < nums[right]) {
                left = mid + 1;
                continue;
            }
            int check = check(nums, mid);
            if (check == 0) {
                return mid;
            } else if (check == -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static int check(int[] nums, int index) {
        int left = index == 0 ? Integer.MIN_VALUE : nums[index - 1];
        int right = index == nums.length - 1 ? Integer.MIN_VALUE : nums[index + 1];
        if (nums[index] >= left && nums[index] >= right) {
            return 0;
        } else if (nums[index] >= left) {
            return -1;
        } else {
            return 1;
        }
    }


    public static void main(String[] args) {
        findPeakElement2(new int[]{1,2,1,3,5,6,4});
    }


    /*
     * 上面题解 逻辑较为繁琐
     * 参考官方题解
     * 局部上升 仅需要比较mid左右位置即可。
     *
     * */
    public static int findPeakElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (mid > 0 && nums[mid] < nums[mid - 1]){
                //mid 左侧局部上升
                right = mid-1;
                continue;
            }
            if (mid<nums.length-1 && nums[mid]<nums[mid+1]){
                left = mid+1;
                continue;
            }
            return mid;
        }
        return left;
    }
}
