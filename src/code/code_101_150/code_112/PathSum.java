package code.code_101_150.code_112;

import code.common.TreeNode;

public class PathSum {

    /*
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such
     * that adding up all the values along the path equals the given sum.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given the below binary tree and sum = 22,
     *           5
     *          / \
     *         4   8
     *        /   / \
     *       11  13  4
     *      /  \      \
     *     7    2      1
     *
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     *
     * 目标：给定树，判断是否存在从根节点到叶子节点的路径，使得路径和为 指定sum
     *
     * 算法：
     * 自底向上计算出当前节点为根节点的左右path的路径和 分为左path 以及 右path两个
     *
     * TODO:  学习官方解法中的 递归与迭代方法 https://leetcode-cn.com/problems/path-sum/solution/lu-jing-zong-he-by-leetcode/
     * 并实现迭代递归方法
     *
     * */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return doCheckSum(root, sum);
    }

    private static boolean doCheckSum(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            return sum == node.val;
        }
        int left = sum - node.val;
        if (node.left != null) {
            boolean leftRes = doCheckSum(node.left, left);
            if (leftRes) {
                return leftRes;
            }
        }
        if (node.right != null) {
            return doCheckSum(node.right, left);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        boolean b = hasPathSum(root, 22);
        System.out.println(b);

    }
}
