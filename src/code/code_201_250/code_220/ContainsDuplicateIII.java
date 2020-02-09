package code.code_201_250.code_220;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII {

    /*
     * Given an array of integers, find out whether there are two distinct indices i and j
     * in the array such that the absolute difference between nums[i] and nums[j]
     * is at most t and the absolute difference between i and j is at most k.
     * 给定一个整数数组，找出是否存在两个不同索引的元素满足：
     * 1 差值绝对值最大为t
     * 2 索引下标差值绝对值最大为k
     * Example 1:
     * Input: nums = [1,2,3,1], k = 3, t = 0
     * Output: true
     *
     * Example 2:
     * Input: nums = [1,0,1,1], k = 1, t = 2
     * Output: true
     *
     * Example 3:
     * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
     * Output: false
     *
     * 算法：
     * 1 暴力法
     * 遍历数组
     *   遍历下标小于k的数
     *       比较差值绝对值是否小于等于t
     * 时间复杂度：O(N*K) 空间复杂度：O(1)
     *
     * 2 搜索树
     * 遍历数组
     *   比较搜索树中最小值 最大值
     *       存在与当前元素差值小于等于t的 返回true
     *       不存在 加入搜索树中
     *   如搜索树元素大于等于k个  移除下标为i-k的元素
     * 时间复杂度：O(N*logK) 空间复杂度：O(Min(N,K))
     *
     * 3 差值桶
     * 以t为区间  将元素分到多个桶中  进行分片
     * [0,t) 为第一个桶 [t,2t) 为第二个桶 [2t,3t) 为第三个桶。。。
     * 遍历数组
     *   找到当前元素j所在的桶i
     *       第i个桶中
     *           存在元素 返回true
     *       第i-1个桶中
     *           存在元素 且差值小于t 返回true
     *       第i+1个桶中
     *           存在元素 且差值小于t 返回true
     *       将当前元素加入桶中
     *   如j>k 移除下标为i-k的元素
     *
     * 数据分片策略：
     * ...[-t,0)[0,t)[t,2t)...
     *
     * 如t = 3
     * 对于 value 为[3,6) 通过value/t 定位到桶1
     * 对于 value 为[0,3) 通过value/t 定位到桶0
     * 对于 value 为[-3,0) 通过(value+1)/t-1 定位到桶-1  因为-3要定位到-1 需要先+1
     * 对于 value 为[-6,-3) 通过(value+1)/t-1 定位到桶-2
     *
     * todo 此路由问题 不能兼容t==0的情况  因此需要使用t+1作为除数路由 因此每个区间段需要包含t+1个元素
     *
     *  ...[-t-1,-1], [0,t], [t+1, 2t+1], ...  每个桶包含t+1个元素
     * 如t = 3
     * w = t+1 = 4
     * 对于 value 为[4,8) 通过value/w 定位到桶1
     * 对于 value 为[0,4) 通过value/w 定位到桶0
     * 对于 value 为[-4,0) 通过(value+1)/w-1 定位到桶-1  因为-4要定位到-1 需要先+1
     * 对于 value 为[-8,-4) 通过(value+1)/w-1 定位到桶-2
     *
     * 时间复杂度：O(N) 空间复杂度: O(Min(N,K))
     *
     * todo 算法学习  参考官方题解即可
     *
     * 未通过用例：
     * Input: nums = [1,2,3,1], k = 3, t = 0
     * Output: true
     * 原因 k最小值为1 但是t最小值为0  不是1
     *
     * 未通过用例：
     * Input nums = [-1,2147483647], k = 1, t = 2147483647
     * Output: false
     * 原因： 未考虑到整数溢出 如 2147483647-(-1) 得到值为-2147483648 <t
     * 解决： 转为long进行计算比较
     *
     * */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null || nums.length < 2) {
            return false;
        }
        TreeSet<Integer> cache = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = cache.ceiling(nums[i]);
            if (ceiling != null && ceiling - (long) nums[i] <= t) {
                return true;
            }
            Integer floor = cache.floor(nums[i]);
            if (floor != null && (long) nums[i] - floor <= t) {
                return true;
            }
            cache.add(nums[i]);
            if (i >= k) {
                cache.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new ContainsDuplicateIII().containsNearbyAlmostDuplicate2(new int[]{1, 2, 3, 1}, 3, 0);
        System.out.println(b);
    }

    /*
     * 使用k元素桶分片算法实现
     * */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> cache = new HashMap<>();
        int w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int id = getBucketId(nums[i], w);
            if (cache.containsKey(id)) {
                return true;
            }
            Integer prev = cache.get(id - 1);
            if (prev != null && (long) nums[i] - prev <= t) {
                return true;
            }
            Integer next = cache.get(id + 1);
            if (next != null && next - (long) nums[i] <= t) {
                return true;
            }
            cache.put(id, nums[i]);
            if (i >= k) {
                cache.remove(getBucketId(nums[i - k], w));
            }
        }
        return false;
    }

    private int getBucketId(int value, int w) {
        return value < 0 ? (value + 1) / w - 1 : value / w;
    }
}
