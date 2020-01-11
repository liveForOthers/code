package code.code_101_150.code_124;

import code.common.TreeNode;

public class BinaryTreeMaximumPathSum {

    /*
     * Given a non-empty binary tree, find the maximum path sum.
     *
     * For this problem, a path is defined as any sequence of nodes
     * from some starting node to any node in the tree along the parent-child connections.
     * The path must contain at least one node and does not need to go through the root.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     *       1
     *      / \
     *     2   3
     *
     * Output: 6
     *
     * Example 2:
     *
     * Input: [-10,9,20,null,null,15,7]
     *
     *   -10
     *   / \
     *  9  20
     *    /  \
     *   15   7
     *
     * Output: 42
     *
     * 目标： 给定二叉树，找出节点和最大的路径和
     * 路径：任意节点触发通过 父子链接 到任意节点为止，可不包含根节点
     *
     * 算法：
     * 递归 或迭代
     * 自底向上计算出 当前节点为根节点的  经过当前节点的最大路径和 每次更新当前path的最大和
     * 递归函数返回 包含当前节点的最大和
     * 时间复杂度：O(N) 空间复杂度：O(logN)
     *
     * TODO bugfree  还是又困难  要提前想好所有可能情况  多给出case  然后将逻辑分为几类
     *
     * */
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return (int)maxPathSum;
    }

    private static long maxPathSum = Long.MIN_VALUE;

    private static long dfs(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        long left = dfs(node.left);
        long right = dfs(node.right);

        // 包含了左右双节点  此时不允许链接爷爷节点
        maxPathSum = Math.max(maxPathSum, left + right + node.val);
        // 包含了父节点且 (包含左右单节点或 仅包含父节点) 此时可链接爷爷节点的情况
        long childMax = Math.max(left, right);
        long res = Math.max(node.val + childMax, node.val);
        maxPathSum = Math.max(maxPathSum, res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        /* root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
*/
        int i = maxPathSum(root);
        System.out.println(i);
    }
}
