package code.code_151_200.code_169;

public class MajorityElement {
    /*
     * 找到给定数组中出现超过n/2次的元素
     * 算法：
     * 记录当前元素以及频次  清零后重新记录
     * 时间复杂度O(N) 空间复杂度O(1)
     * */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                count++;
                continue;
            }
            if (count == 0) {
                cur = nums[i];
                count = 1;
                continue;
            }
            count--;
        }
        return cur;
    }
}
