package code.code_1_50.code_0033;

public class SearchInRotatedSortedArray {
    /*
     * 举个栗子：
     * Input: nums = [4,5,6,7,0,1,2], target = 0  Output: 4
     *
     * 难点：二分法  但不是单纯的有序数组 而是经过旋转后的数组
     *
     * 策略：
     * 1 使用 二分法 找到中间值mid
     *     a 如 mid==target 则直接返回 mid 下标
     *     b 如 mid<target (接下来判断mid左有序 还是右侧有序)
     *              b1 如 mid>left 则说明 mid 左有序 left = mid+1
     *              b2 如 mid<left 则说明 mid 右有序
     *                       b21 如 right>target 则target在mid右侧 left = mid+1
     *                       b22 如 right<target 则target在mid左侧 right = mid-1
     *                       b23 如 right==target 则直接返回right
     *              b3 如 mid==left 则 left++
     *     c 如 mid>target (接下来判断mid左有序 还是右侧有序)
     *              同上类比，不再赘述
     *
     * */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[mid] > nums[left]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[left]) {
                    if (nums[right] > target) {
                        left = mid + 1;
                    } else if (nums[right] < target) {
                        right = mid - 1;
                    } else {
                        return right;
                    }
                // 兼容 数组中存在两数相等情况
                } else {
                    left++;
                }
                // nums[mid] 比 target 大
            } else {
                // mid 右侧有序
                if (nums[mid] < nums[right]) {
                    right = mid - 1;
                // mid 左侧有序  比较左侧边界
                } else if (nums[mid] > nums[right]){
                    if (nums[left]>target){
                        left = mid+1;
                    }else if(nums[left]<target){
                        right = mid-1;
                    }else{
                        return left;
                    }
                }else {
                    right--;
                }
            }
        }
        return -1;
    }


}
