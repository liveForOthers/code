package code.code_101_150.code_129;

import code.common.TreeNode;

public class SumRootToLeafNumbers {

    /*
     * Given a binary tree containing digits from 0-9 only,
     * each root-to-leaf path could represent a number.
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     *
     * Find the total sum of all root-to-leaf numbers.
     * Note: A leaf is a node with no children.
     *
     * 目标：每个节点值为0-9，每个根节点到叶子节点代表一个数，找到所有数的和
     * Example:
     * Input: [1,2,3]
     *   1
     *  / \
     * 2   3
     *
     * Output: 25
     *
     * Explanation:
     *
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     *
     * Therefore, sum = 12 + 13 = 25.
     *
     * Example 2:
     *
     * Input: [4,9,0,5,1]
     *       4
     *      / \
     *     9   0
     *    / \
     *   5   1
     * Output: 1026
     *
     * Explanation:
     * The root-to-leaf path 4->9->5 represents the number 495.
     * The root-to-leaf path 4->9->1 represents the number 491.
     * The root-to-leaf path 4->0 represents the number 40.
     * Therefore, sum = 495 + 491 + 40 = 1026.
     *
     * 算法：
     * 递归 or 迭代  迭代不能优化复杂度 仅仅为实现的一种
     * 自顶向下处理 如果遇到叶子节点  将当前数加到结果中
     * 最终返回结果
     *
     * 时间复杂度:O(N)  空间复杂度:O(logN)
     *
     * TODO 再细心
     * */
    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return res;
    }

    private static void dfs(TreeNode node, int num) {
        num = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += num;
            return;
        }
        if (node.left != null) {
            dfs(node.left, num);
        }
        if (node.right != null) {
            dfs(node.right, num);
        }
    }

    static int res = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        sumNumbers(root);
    }
}
