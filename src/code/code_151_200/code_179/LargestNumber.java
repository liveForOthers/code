package code.code_151_200.code_179;

import com.oracle.net.Sdp;

import java.util.*;

public class LargestNumber {

    /*
     * Given a list of non negative integers, arrange them such that they form the largest number.
     *
     * Example 1:
     * Input: [10,2]
     * Output: "210"
     *
     * Example 2:
     * Input: [3,30,34,5,9]
     * Output: "9534330"
     *
     * Note: The result may be very large, so you need to return a string instead of an integer.
     *
     *
     * 目标：从给定数组中选取数字依次排列 找出其中最大的数 返回值非常大 返回字符串
     * 算法：
     * 将数组中的数进行排序
     * 排序规则：
     * 从前到后 数值大的在前面
     * [34,3434,3333330]
     *
     * TODO 深入领悟排序的方法 https://leetcode-cn.com/problems/largest-number/solution/zui-da-shu-by-leetcode/
     * 未通过示例：
     * "[0,0]"
     * 解决  排序后 判断首位为0  直接return
     *
     * */
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        List<String> array = new ArrayList<>(nums.length);
        for (int cur : nums) {
            array.add(String.valueOf(cur));
        }
        array.sort(new arrayCompare2());
        if (Integer.valueOf(array.get(0)) == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String cur : array) {
            res.append(cur);
        }
        return res.toString();
    }

    static class arrayCompare implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
                throw new IllegalArgumentException("参数异常");
            }
            return doCompare(s1, s2);
        }

        private int doCompare(String s1, String s2) {
            if (s1.length() == s2.length()) {
                return Integer.valueOf(s2) - Integer.valueOf(s1);
            }
            if (s1.length() < s2.length()) {
                int n1 = Integer.valueOf(s1);
                int n2 = Integer.valueOf(s2.substring(0, s1.length()));
                if (n1 == n2) {
                    return doCompare(s1, s2.substring(s1.length(), s2.length()));
                }
                return n2 - n1;
            }
            return doCompare(s2, s1) * (-1);
        }
    }


    public static void main(String[] args) {
        String s = largestNumber(new int[]{10, 2});
        System.out.println(s);
    }

    static class arrayCompare2 implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
                throw new IllegalArgumentException("参数异常");
            }
            return doCompare(s1, s2);
        }

        private int doCompare(String s1, String s2) {
            String str1 = s1 + s2;
            String str2 = s2 + s1;
            return str2.compareTo(str1);
        }
    }


}
