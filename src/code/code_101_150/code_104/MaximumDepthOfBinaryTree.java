package code.code_101_150.code_104;

import code.common.TreeNode;

public class MaximumDepthOfBinaryTree {

    /*
     * Given a binary tree, find its maximum depth.
     *
     * The maximum depth is the number of nodes
     * along the longest path from the root node down to the farthest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given binary tree [3,9,20,null,null,15,7],
     * return its depth = 3.
     *
     * 目标：给定树 找出树最深的深度
     *
     * 算法：
     * 递归实现，返回当前节点为根节点的最深深度
     *
     * 时间复杂度：O(N) 空间复杂度:O(N)
     *
     * 迭代实现：
     * 1 层序遍历   时间复杂度：O(N) 空间复杂度:O(N)
     * 2 官方给出的方法
     *
     * */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = maxDepth(root);
        System.out.println(i);
    }
}
