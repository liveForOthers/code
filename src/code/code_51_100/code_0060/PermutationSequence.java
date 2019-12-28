package code.code_51_100.code_0060;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    /*
     * Note:
     * Given n will be between 1 and 9 inclusive.
     * Given k will be between 1 and n! inclusive.
     * Example 1: Input: n = 3, k = 3  Output: "213"
     * Example 2: Input: n = 4, k = 9  Output: "2314"
     *
     * 目的： 找出由 1，2，3...n 共n个数字组成的由小到大的有序排列中
     *       第k个排列
     *
     * 算法： n 个数字 任选一个作为头 则以该数字为头的 排列有(n-1)!个
     *       为了找到第k个排列   头数字应该为 k/(n-1)!
     *       ... ... ... .. 第i个数字应该为 k/(n-i)!
     *
     * 栗子： n = 3,k = 5 则集合为 1 2 3
     *       k--; k =4
     *       第1个数字为  4/(3-1)! = 2 则头数字为3 新集合为 1 2
     *       新的k为 4 - 2*(3-1)! = 0
     *       第2个数字为 0/(3-2)! = 0 则第2位数字为1 新集合为 2
     *       新的k为 0 - (0)*(3-2)! = 0
     *       集合中仅剩一个元素 直接加到尾部即可
     *
     * 收获：分析方法、思路很重要  好像是某某定理 忘了
     *
     * */
    public static String getPermutation(int n, int k) {
        if (k <= 0 || n > 9 || n < 1) {
            throw new IllegalArgumentException("参数异常");
        }
        int counts = 1;
        for (int i = 2; i <= n; i++) {
            counts *= i;
        }
        if (k > counts) {
            throw new IllegalArgumentException("参数异常");
        }
        counts = counts / n;
        k--;
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < n; i++) {
            // 计算第i个数的 下标
            int index = k / counts;
            res.append(nums.get(index));
            // 清除集合中已使用的元素
            nums.remove(index);
            // 更新k
            k = k - index * counts;
            // 更新阶乘
            counts = counts / (n - i);
        }
        res.append(nums.get(0));
        return res.toString();
    }

    public static void main(String[] args) {
        getPermutation(3, 5);
    }
}
