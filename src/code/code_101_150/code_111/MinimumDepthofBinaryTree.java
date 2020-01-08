package code.code_101_150.code_111;

import code.common.TreeNode;
import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepthofBinaryTree {

    /*
     * Given a binary tree, find its minimum depth.
     *
     * The minimum depth is the number of nodes along the shortest path
     * from the root node down to the nearest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given binary tree [3,9,20,null,null,15,7],
     *   3
     *  / \
     * 9  20
     *   /  \
     *  15   7
     *
     * return its minimum depth = 2.
     *
     * 目标：给定树，返回该树最小的深度
     *
     * 算法：
     * 自底向上，每次左右子深度，保留最小深度
     *
     * 时间复杂度: O(N) 空间复杂度：O(logN)
     *
     * 本次实现为 递归实现，可以考虑使用迭代实现
     *
     * TODO 迭代实现
     * */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null || root.right == null) {
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /*
     * 使用迭代进行实现
     * 本质是 使用栈模拟dfs
     *          队列模拟 bfs
     * */
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Pair<TreeNode, Integer> pair = new Pair<TreeNode, Integer>(root, 1);
        Deque<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(pair);
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curPair = queue.pop();
            if (curPair.getKey().left == null && curPair.getKey().right == null) {
                return curPair.getValue();
            }
            if (curPair.getKey().left != null) {
                queue.offer(new Pair<>(curPair.getKey().left, curPair.getValue() + 1));
            }
            if (curPair.getKey().right != null) {
                queue.offer(new Pair<>(curPair.getKey().right, curPair.getValue() + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        minDepth2(root);
    }


}
