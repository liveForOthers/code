package code.code_51_100.code_0098;

import code.common.TreeNode;

public class ValidateBinarySearchTree {
    /*
     *
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     *
     * Assume a BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     * Example 1:
     *     2
     *    / \
     *   1   3
     *
     * Input: [2,1,3]
     * Output: true
     *
     * Example 2:
     *
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     *
     * Input: [5,1,4,null,null,3,6]
     *
     * Output: false
     *
     * Explanation: The root node's value is 5 but its right child's value is 4.
     *
     * 目标： 给定树根节点  判断该树是否为二叉查找树
     *
     * 算法：
     * 判定规则：值大小 左<根<右
     * 维护最大值 最小值两个参数
     * 如 存在cur<最小值 或 cur>最大值 则无效
     * 否则 有效
     *
     * 学习：
     * 未通过用例：
     * 1 [1,1]
     *   用例不支持具有相同元素的bst
     * 2 [2147483647]
     *   要考虑到边界极值  使用long取代int
     * */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean doValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return doValidBST(node.left, min, Math.min(max, node.val))
                && doValidBST(node.right, Math.max(min, node.val), max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        boolean validBST = isValidBST(root);

        System.out.println(validBST);
    }
}
