package code.code_101_150.code_137;

public class SingleNumberII {

    /*
     * Given a non-empty array of integers, every element appears three times except for one,
     * which appears exactly once. Find that single one.
     *
     * Note:
     * Your algorithm should have a linear runtime complexity.
     * Could you implement it without using extra memory?
     *
     * Example 1:
     * Input: [2,2,3,2]
     * Output: 3
     *
     * Example 2:
     *
     * Input: [0,1,0,1,0,1,99]
     * Output: 99
     *
     * 目标：找出仅出现一次的数，其余数字抖出现三次
     * 算法:
     *
     * todo 回顾  学习：https://www.cnblogs.com/grandyang/p/4263927.html
     *
     * 仅有一个数字出现一次，其余数字出现n次的通用思路：
     * 制定一种运算规则，当相同的数执行了n次后执行清零  博客中方法3
     * 如n=2
     * 1 1 2
     * 1^1 = 0(1 出现了两次 进行清零)
     *
     * n=3
     * 1 1 2 1
     * 1 # 1 # 1  = 0（1出现三次执行清零）
     *
     * 通用方法： 博客中方法2
     * 三个数分别表示 出现一次 出现二次 出现三次
     * one,two,three
     * two |= one & cur
     * one = cur^one
     * three = one & two //看看是否要清空这个数
     * one &= ~three // 满三次清零
     * two &= ~three // 满三次清零
     *
     *
     *
     *
     *
     *
     * TODO coding
     * */
    public int singleNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("参数异常");
        }
        throw new IllegalArgumentException("待coding");
    }
}
