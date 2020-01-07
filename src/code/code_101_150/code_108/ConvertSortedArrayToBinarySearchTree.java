package code.code_101_150.code_108;

import code.common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    /*
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree
     * in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted array: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     * 目标：给定升序数组，将其转化为平衡二叉搜索树
     *
     * 算法：
     *
     * 二分找到mid作为当前根节点
     * mid 左侧作为左孩子
     * mid 右侧作为右孩子
     *
     * 递归实现
     *
     * 时间复杂度：O(N) 空间复杂度：O(N)
     *
     * 学习：
     * code友给出了两种迭代写法：
     * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-24/
     *
     * */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return doBuildBST(nums, 0, nums.length);
    }

    private static TreeNode doBuildBST(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int midIndex = (left + right) >>> 1;
        TreeNode res = new TreeNode(nums[midIndex]);
        res.left = doBuildBST(nums, left, midIndex);
        res.right = doBuildBST(nums, midIndex + 1, right);
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }

}
