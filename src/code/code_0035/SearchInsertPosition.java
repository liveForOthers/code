package code.code_0035;

public class SearchInsertPosition {

    /*
     *  举个栗子： Input: [1,3,5,6], 2 Output: 1
     *  找到待插入元素 在有序数据中的位置 并保证原数组有序
     *  找到 目标元素的 后继节点（离目标元素最近的 比目标元素大的下标）
     *  二分查找
     * */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}
