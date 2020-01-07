package code.code_101_150.code_110;

import code.common.TreeNode;

public class BalancedBinaryTree {
    /*
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as:
     *
     * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     *
     * Example 1:
     *
     * Given the following tree [3,9,20,null,null,15,7]:
     *
     *   3
     *  / \
     * 9  20
     *   /  \
     *  15   7
     *
     * Return true.
     *
     * 目标： 判断给定树是否是平衡树
     *       平衡树：树中任何节点构成的树 与 兄弟节点构成的树的高度差 小于等于1
     * 算法：
     *
     * 1 自顶到底，分别计算左右节点高度比较高度差，再递归去计算左子行程的树 以及  右子行程的树
     *   问题：大量重复计算，时间复杂度：O(N*logN) 空间复杂度：O(logN)
     *
     * 2 自底到顶+边计算边比较+快速失败
     *   从叶子向上开始边比较边计算，如有一个不符合返回 标志，后续无需重复计算
     *
     * TODO: coding
     * */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        throw new IllegalArgumentException("待coding");
    }


}
