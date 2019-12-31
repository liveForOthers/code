package code.code_51_100.code_0080;

public class RemoveDuplicatesFromSortedArrayII {

    /*
     *
     * Example 1:
     *
     * Given nums = [1,1,1,2,2,3],
     *
     * Your function should return length = 5,
     * with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
     *
     * It doesn't matter what you leave beyond the returned length.
     *
     * Example 2:
     *
     * Given nums = [0,0,1,1,1,1,2,3,3],
     *
     * Your function should return length = 7,
     * with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
     *
     * It doesn't matter what values are set beyond the returned length.
     *
     * 目标：使用原地算法  删除数组中超过2次重复的元素
     *
     * 算法：
     * 目标数组有序，则判断是否超过两次可以通过 nums[i] == nums[index-2] 来进行判定
     * 同理 对于不允许超过n次重复 则使用 nums[i] == nums[index-n] 进行判定
     *
     * */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[index - 2]) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
    }
}
