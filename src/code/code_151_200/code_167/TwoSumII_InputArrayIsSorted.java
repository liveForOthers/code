package code.code_151_200.code_167;

public class TwoSumII_InputArrayIsSorted {

    /*
     * Given an array of integers that is already sorted in ascending order,
     * find two numbers such that they add up to a specific target number.
     * 给定有序整数数组，找到两个数，其和为指定值
     * The function twoSum should return indices of the two numbers such that
     * they add up to the target, where index1 must be less than index2.
     * 返回两个数的下标，前一个下标小于后面的下标
     * Note:
     * Your returned answers (both index1 and index2) are not zero-based.
     * 下标是从1开始的  不是0
     * You may assume that each input would have exactly one solution and
     * you may not use the same element twice.
     * 每一个输入一定会有一个解 并且一个数只能被使用一次
     * Example:
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
     *
     * 算法：
     * 因为有序，在确定开始点后 可以使用二分查找
     * 时间复杂度O(N*logN)
     *
     * */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2) {
            return res;
        }
        int half = target >> 1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > half) {
                break;
            }
            int index = search(numbers, i + 1, target - numbers[i]);
            if (index <= i) {
                continue;
            }
            res[0] = i + 1;
            res[1] = index + 1;
            return res;
        }
        return res;
    }

    private int search(int[] numbers, int left, int target) {
        if (left >= numbers.length) {
            return -1;
        }
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /*
     * todo n数和 经典算法：双指针加逼
     * 时间复杂度：O(N)
     *
     * */
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2) {
            return res;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (sum > target) {
                right--;
            }else {
                left++;
            }
        }
        return res;
    }
}
