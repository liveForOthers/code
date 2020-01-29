package code.code_151_200.code_189;

public class RotateArray {
    /*
     * Given an array, rotate the array to the right
     * by k steps, where k is non-negative.
     *
     * Try to come up as many solutions as you can,
     * there are at least 3 different ways to solve this problem.
     * Could you do it in-place with O(1) extra space?
     *
     * 将数组旋转k步  使用原地算法
     *
     * 算法：
     * [1,2,3,4,5,6,7] and k = 3
     * [5,6,7,1,2,3,4]
     * [4,5,6,7,1,2,3]
     * a[i] -> a[i+3] -> a[i+6]
     * (i+ nk)%length == i+mk 此时进行终止 i++ 继续处理  直到 n个数 都进行了移动
     * 时间复杂度：O(N)  空间复杂度:O(1)
     *
     * TODO 学习下三次旋转实现数组旋转方法 https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
     * 本质上是遍历了两遍数组
     * */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int count = 0;
        int i = 0;
        while (count < nums.length) {
            int headIndex = i + k;
            int nextIndex = headIndex;
            int curVal = nums[headIndex];
            nums[headIndex] = nums[i];
            int nextVal;
            while (count++ < nums.length) {
                nextIndex = (nextIndex + k) % nums.length;
                if (nextIndex==headIndex){
                    break;
                }
                nextVal = nums[nextIndex];
                nums[nextIndex] = curVal;
                curVal = nextVal;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6,7};
        rotate(ints, 3);
        System.out.println(ints);
    }
}
