package code.code_0027;


public class RemoveElement {

    /*
    *  没啥好说的  细心注意循环中指针变换
    * */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int cur : nums) {
            if (cur == val) {
                continue;
            }
            nums[index++] = cur;
        }
        return index;
    }
}
