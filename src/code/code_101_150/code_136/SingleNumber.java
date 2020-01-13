package code.code_101_150.code_136;

public class SingleNumber {

    /*
    * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    *
    * Note:
    *
    * Your algorithm should have a linear runtime complexity.
    * Could you implement it without using extra memory?
    *
    * Example 1:
    *
    * Input: [2,2,1]
    * Output: 1
    *
    * Example 2:
    * Input: [4,1,2,1,2]
    * Output: 4
    *
    * 目标：找到给定数组中仅出现一次的数，其余的数每个出现两次
    * 算法：
    * 每个数进行异或 剩下的数就是单个的数
    * 时间复杂度：O(N)  空间复杂度: O(1)
    * */
    public static int singleNumber(int[] nums) {
        if (nums==null || nums.length==0){
            throw new IllegalArgumentException("参数异常");
        }
        int res = 0;
        for (int cur:nums){
            res = res ^ cur;
        }
        return res;
    }

    public static void main(String[] args) {
        singleNumber(new int[]{2,2,1});
    }
}
