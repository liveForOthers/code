package code.code_101_150.code_103;

import code.common.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    /*
     * Given a binary tree, return the zigzag level order traversal of its nodes' values.
     * (ie, from left to right, then right to left for the next level and alternate between).
     *
     * For example:
     *
     * Given binary tree [3,9,20,null,null,15,7],
     *
     * return its zigzag level order traversal as:
     *
     * [[3],[20,9],[15,7]]
     *
     * 目标: 给定树，一正一反的层序遍历树
     *
     * 算法：
     * 类似层序遍历处理
     *
     * 学习：
     * 对每一层顺序相反处理：
     * 为了避免数组reverse带来的消耗
     * 使用链表进行实现
     * 如正序  加入链表尾巴
     * 如反序  加入链表头
     *
     * 时间复杂度: O(N) 空间复杂度：O(N)
     * */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> tmp = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            List<Integer> cur = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    cur.add(node.val);
                } else {
                    cur.add(0, node.val);
                }
                if (node.left != null) {
                    tmp.offer(node.left);
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                }
            }
            res.add(cur);
            Deque<TreeNode> helper = tmp;
            tmp = queue;
            queue = helper;
            leftToRight = !leftToRight;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        zigzagLevelOrder(root);
    }
}
