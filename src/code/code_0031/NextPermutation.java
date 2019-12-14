package code.code_0031;

public class NextPermutation {
    /*
     *  原理在代码注释中
     *  原理很重要  code 不重要
     * */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 从后向前遍历 找到第一个下表i 满足 nums[i]<nums[i+1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 此时右侧数字序列都是降序的 以满足局部最大序列
        // i 不存在 数目当前数组为最大序列 反转当前数组 变为最小
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // i 存在 从i向后找到比i大 且差最小的下表j
        int j = i + 1;
        while (j < nums.length && nums[j] > nums[i]) {
            j++;
        }
        j--;
        // 交换 i, j 此时 j右侧 仍未局部最大序列
        swap(nums, i, j);
        // 在新nums[j] 上位的情况下 将 i 右侧序列反转成 局部最小序列 则为最大i的下一个序列
        reverse(nums,i+1,nums.length-1);
    }

    private void reverse(int[] nums, int left, int right) {
        if (left < 0 || right >= nums.length) {
            throw new IllegalArgumentException("参数异常");
        }
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int cur = nums[i];
        nums[i] = nums[j];
        nums[j] = cur;
    }


}
