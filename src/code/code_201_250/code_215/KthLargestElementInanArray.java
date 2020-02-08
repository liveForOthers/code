package code.code_201_250.code_215;

import java.util.PriorityQueue;

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
     *
     * 相比于暴力排序方法 每次partition后都减少了一半数据的处理 时间复杂度降低
     *
     * 借鉴快排的partition思想，选取基数，找到从小到大排列时 基数的位置索引i 则基数是从大到小排列第end-i个数(end是不可达索引)
     * 如 end-i >k  说明end -i 以及其前面的数都是无用的数 begin = i+1(begin 是可达索引)
     * 如 end-i==k  说明基数是第k大数  返回基数
     * 如 end-i<k   说明基数以及i后面的数比第k大数大  更新end = i 且 k = k-(end-i)
     * 最坏情况下需要partition (n-k)次 也就是每次仅干掉一个数
     *
     * 2 优先队列
     * 时间复杂度: O(N*logK) 空间复杂度：O(K)
     *
     * 优点：适用于海量数据处理，不必把所有数据全都读到内存中，内存仅需要存储k个元素即可满足需求，读一点处理一点
     *
     * 建立小顶堆最多存k个数，如k个已经存满，将当前数与队头数比较，
     * 如比队头数大 说明队头不是目标数 队头出队 当前数入队
     * 如比队头数小或等于 则处理下一个数
     *
     * todo: 时间复杂度的计算复习
     * */
    public int findKthLargest(int[] nums, int k) {
        //todo 代码实现写的太烂了 见findKthLargest1
        if (k < 1 || nums == null || nums.length < k) {
            throw new IllegalArgumentException("params are error");
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int cur : nums) {
            if (queue.size() < k) {
                queue.offer(cur);
                continue;
            }
            Integer peek = queue.peek();
            if (cur <= peek) {
                continue;
            }
            queue.poll();
            queue.offer(cur);
        }
        return queue.poll();
    }

    public int findKthLargest1(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < k) {
            throw new IllegalArgumentException("params are error");
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1);
        for (int cur : nums) {
            queue.offer(cur);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }


    /*
     * 借鉴partition思想  分治快速查找
     * */
    public int findKthLargest2(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < k) {
            throw new IllegalArgumentException("params are error");
        }
        return partition(nums, 0, nums.length, k);
    }

    private int partition(int[] nums, int begin, int end, int k) {
        //todo 优化基准值  每次使用中值取代基准值
        int middle = (begin + end) >>> 1;
        swap(nums, begin, middle);
        //找到基准元素位置
        int index = findIndex(nums, begin, end);
        //则基数是从大到小排列第end-i个数(end是不可达索引)
        //如 end-i >k  说明end -i 以及其前面的数都是无用的数 begin = i+1(begin 是可达索引)
        int cur = end - index;
        if (cur > k) {
            return partition(nums, index + 1, end, k);
        }
        //如 end-i==k  说明基数是第k大数  返回基数
        if (cur == k) {
            return nums[index];
        }
        //如 end-i<k   说明基数以及i后面的数比第k大数大  更新end = i 且 k = k-(end-i)
        return partition(nums, begin, index, k - cur);
    }

    private int findIndex(int[] nums, int begin, int end) {
        int baseValue = nums[begin];
        int left = begin;
        int right = end - 1;
        while (left < right) {
            while (left < right && nums[right] >= baseValue) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= baseValue) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = baseValue;
        return left;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 5, 6, 4};
        int kthLargest = new KthLargestElementInanArray().findKthLargest2(ints, 2);
        System.out.println(kthLargest);
    }


}
