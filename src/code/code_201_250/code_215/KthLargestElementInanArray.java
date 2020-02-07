package code.code_201_250.code_215;

public class KthLargestElementInanArray {

    /*
    * Find the kth largest element in an unsorted array.
    * Note that it is the kth largest element in the sorted order, not the kth distinct element.
    * 找到第k个最大的元素在一个无序数组中
    * 不是要求去重后第k大元素  重复的两个元素算两个
    * Example 1:
    *
    * Input: [3,2,1,5,6,4] and k = 2
    * Output: 5
    *
    * Example 2:
    *
    * Input: [3,2,3,1,2,4,5,5,6] and k = 4
    * Output: 4
    *
    * Note:
    * You may assume k is always valid, 1 ≤ k ≤ array's length.
    *
    * 算法：
    * 1 partition思想
    * 时间复杂度: 平均情况O(N)，最坏情况O(N^2) 想一想为啥最好情况下是线性  空间复杂度O(1)
    * 借鉴快排的partition思想，选取基数，找到从小到大排列时 基数的位置索引i 则基数是从大到小排列第end-i个数(end是不可达索引)
    * 如 end-i >k  说明end -i 以及其前面的数都是无用的数 begin = i+1(begin 是可达索引)
    * 如 end-i==k  说明基数是第k大数  返回基数
    * 如 end-i<k   说明基数以及i后面的数比第k大数大  更新end = i 且 k = k-(end-i)
    * 最坏情况下需要partition (n-k)次 也就是每次仅干掉一个数
    *
    * 2 优先队列
    * 时间复杂度: O(N*logK) 空间复杂度：O(K)
    *
    * 建立小顶堆最多存k个数，如k个已经存满，将当前数与队头数比较，
    * 如比队头数大 说明队头不是目标数 队头出队 当前数入队
    * 如比队头数小或等于 则处理下一个数
    *
    * todo: 时间复杂度的计算
    * */
    public int findKthLargest(int[] nums, int k) {
        throw new IllegalArgumentException("coding");
    }
}
