package code.code_51_100.code_0088;

public class MergeSortedArray {

    /*
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     *
     * Note:
     *
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     *
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     *
     * Example:
     *
     * Input:
     *
     * nums1 = [1,2,3,0,0,0], m = 3
     *
     * nums2 = [2,5,6],       n = 3
     *
     * Output: [1,2,2,3,5,6]
     *
     * 算法：
     * 新建数组
     * 遍历nums2 数组 与nums1数组 将其放入新建数组中
     * 将新建数组 赋值给nums1
     *
     * 时间复杂度：O(M+N) 空间复杂度：O(M+N)
     *
     * 学习： 空间复杂度优化：  使用双指针法  从后往前写nums1数组 见merge2
     *
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || m < 0 || n < 0 || nums1.length < m + n || nums2.length < n) {
            return;
        }
        int[] res = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m || index2 < n) {
            int val1 = index1 == m ? (nums2[index2] + 1) : nums1[index1];
            int val2 = index2 == n ? (nums1[index1] + 1) : nums2[index2];
            if (val1 < val2) {
                res[index++] = val1;
                index1++;
            } else {
                res[index++] = val2;
                index2++;
            }
        }
        for (int i = 0; i < res.length; i++) {
            nums1[i] = res[i];
        }
    }

    /*
     *
     * 算法：
     * 从后往前(从大到小写nums1) 直到把nums2写完
     * from index m+n-1 to 0 直到 数组2被遍历完毕
     * 算法标识： 给出了有效数字个数 m，n 用于倒着比较写入
     *
     * */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || m < 0 || n < 0 || nums1.length < m + n || nums2.length < n) {
            return;
        }
        int index = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            int value1 = m >= 0 ? nums1[m] : nums2[n] - 1;
            int value2 = nums2[n];
            if (value2 >= value1) {
                nums1[index--] = value2;
                n--;
            } else {
                nums1[index--] = value1;
                m--;
            }
        }
    }
}
