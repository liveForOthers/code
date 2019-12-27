package code.code_1_50.code_0041;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int i = firstMissingPositive(new int[]{3, 4, -1, 1});
        System.out.println(i);
    }

    /*
     * 找到数组中 丢失的第一个正数
     * 难点在于  1 常量空间 （考虑原地算法） 2 O(N)时间复杂度
     * 如果不考虑常量空间复杂度  直接 用数组下表关联数组值 即可
     * new 一个新数组缓存值 再遍历一遍看哪个位置没被set进去 就是丢失的第一个正数
     * */
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            int target = nums[i];
            // 满足以下条件的 数都是需要进行交换的
            while (target >= 1 && target <= nums.length && nums[target - 1] != target) {
                int nextTarget = nums[target - 1];
                nums[target - 1] = target;
                target = nextTarget;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
