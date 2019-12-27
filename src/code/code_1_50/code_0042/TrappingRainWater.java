package code.code_1_50.code_0042;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {

    public static void main(String[] args) {
        int trap = trap3(new int[]{5,2,1,2,1,5});
        System.out.println(trap);
    }

    /*
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
     * 思路：粗暴低效方法 暴力法 遍历数组每个元素  找到左侧最高以及右侧最高 计算出当前节点可储水量
     * 时间复杂度 O(n^2)
     * */
    public static int trap1(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int cur = height[i];
            int leftMax = cur;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = cur;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    /*
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
     * 思路：两个数据，分别缓存 第i位置 左侧最高节点 以及 右侧最高节点
     * 对于 left[i] right[i]
     * left[i+1] = max(left[i],cur)
     * right[i-1] = max(right[i],cur)
     * 需要遍历3遍
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * */
    public static int trap2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int[] right = new int[height.length];
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    /*
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
     * 思路：使用栈数据结构， 如 当前节点比栈顶大 则将栈顶 top 出栈，
     * 计算 刚出栈的节点容水量  计算方法： 拿到当前栈顶节点高度 h1 以及下标 index1
     * (cur-index1-1)为间隔数目 * (Math.min(height[cur],h1)-height[top]) 为有效高度
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * */
    public static int trap3(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if (height[stack.peek()] >= height[i]) {
                stack.push(i);
                continue;
            }
            // 处理出栈 并计算容水量
            while (height[stack.peek()] < height[i]) {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                    break;
                }
                int rowCount = i - 1 - stack.peek();
                int high = Math.min(height[stack.peek()], height[i]) - height[pop];
                res += rowCount * high;
            }
            stack.push(i);
        }
        return res;
    }

    /*
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
     * 思路：使用双指针，两个变量维护左侧最高值、右侧最高值
     * 双指针哪个指向的高度低 则移动该指针如 相等可以 任选一个移动
     * 因为节点的储水量 依赖于最低边界高度
     * 如左边极其高  则右边节点蓄水量 完全依赖于 右面最高以及当前节点高度值 rightMax-cur
     *
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * */
    public static int trap4(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
