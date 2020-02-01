package code.code_201_250.code_202;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /*
     * Write an algorithm to determine if a number is "happy".
     * 确定一个数是否是快乐数
     * A happy number is a number defined by the following process:
     * Starting with any positive integer,
     * replace the number by the sum of the squares of its digits,
     * and repeat the process until the number equals 1 (where it will stay),
     * or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy numbers.
     * 以一个正整数开始，使用各位的平方和替换这个数，重复这个过程直到这个数等于1
     * 或进入（不为1的）无限循环状态
     * 以1结束的数是快乐数
     *
     * Example:
     * Input: 19
     * Output: true
     * Explanation:
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     *
     * 算法：
     * 模拟题
     * 使用set缓存每一次的结果 用于判断是否出现循环
     * 结果为1 返回true 否则false
     *
     * 时间复杂度： 不好评估最多 Integer.MAX_VALUE
     * 空间复杂度:  O(N)
     *
     * TODO 学习链表成环算法 解决数成环算法问题：https://leetcode.wang/leetcode-202-Happy-Number.html
     * 优化空间复杂度到O(1) 并且无需每次set查询 时间上更快
     * */
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> cache = new HashSet<>();
        while (!cache.contains(n)) {
            cache.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int num) {
        int res = 0;
        while (num != 0) {
            int cur = num % 10;
            res += cur * cur;
            num = num / 10;
        }
        return res;
    }

    public boolean isHappy2(int n) {
        if (n <= 0) {
            return false;
        }
        int slow = n;
        int fast = n;
        while (true) {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
            if (fast == slow) {
                break;
            }
        }
        return slow == 1;
    }

    public static void main(String[] args) {
        boolean happy = new HappyNumber().isHappy(19);
        System.out.println(happy);
    }
}
