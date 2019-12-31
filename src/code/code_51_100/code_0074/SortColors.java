package code.code_51_100.code_0074;

public class SortColors {

    /*
     * Given an array with n objects colored red, white or blue,
     * sort them in-place so that objects of the same color are adjacent,
     * with the colors in the order red, white and blue.
     *
     * 给定一个数组 包含n个元素，标记为红色、白色或蓝色。
     * 使用原地算法对他们进行排序，以至于 相同颜色的元素是相连的，排序顺序是 红色 白色 以及 蓝色
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * Note: You are not suppose to use the library's sort function for this problem.
     * 使用0、1、2 分别表示 红色、白色以及蓝色
     *
     * 不能使用 库中自带的排序算法
     *
     * Example:
     *
     * Input: [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     *
     * Follow up:
     * A rather straight forward solution is a two-pass algorithm using counting sort.
     *
     * 一个直接的解决办法是使用计数排序 遍历两遍。
     * First, iterate the array counting number of 0's, 1's, and 2's,
     * 首先，迭代数组记录0，1，2 的数目
     * then overwrite array with total number of 0's, then 1's and followed by 2's.
     * 然后，重写数组 使用 0，1，2 的总数
     * Could you come up with a one-pass algorithm using only constant space?
     * 你能想出使用常量空间的一遍遍历的算法
     *
     * 算法：
     * 1 使用两遍遍历计数法
     * 2 双指针法 进行交换
     *
     * 本方法先实现1
     * */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int cur : nums) {
            if (cur == 0) {
                red++;
                continue;
            }
            if (cur == 1) {
                white++;
                continue;
            }
            blue++;
        }
        int index = 0;
        while (red-- > 0) {
            nums[index++] = 0;
        }
        while (white-- > 0) {
            nums[index++] = 1;
        }
        while (blue-- > 0) {
            nums[index++] = 2;
        }
        return;
    }

    /*
     * 双指针法
     *
     * 左右指针
     * 遍历数组：
     *
     * 如果为蓝色 则与右指针交换 右面指针--
     * 如果为红色 则与左指针交换 则左指针++
     * 如果为白色 左右指针不动 继续走
     *
     * 学习：
     * 对于 i 左侧节点（也就是 left 所在位置节点）因为已经遍历处理过了 所以索引 i 也跟着增加
     *
     * */
    public static void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        for (int i = left; i <= right; ) {
            // 当前为红色
            // 对于 i 左侧节点（也就是 left 所在位置节点）因为已经遍历处理过了 所以索引 i 也跟着增加
            if (nums[i] == 0) {
                swap(nums, i++, left++);
                continue;
            }
            // 当前为蓝色
            if (nums[i] == 2) {
                swap(nums, i, right--);
                continue;
            }
            // 当前为白色
            i++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        System.out.println(nums);
    }
}
