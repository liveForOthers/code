package code.code_101_150.code_107;

import code.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {


    /*
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
     * (ie, from left to right, level by level from leaf to root).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *
     * return its bottom-up level order traversal as:
     * [[15,7],[9,20],[3]]
     *
     * 目标：从最底层向上层进行从左到右的层序遍历
     *
     * 算法：
     * 类似层序遍历  当前层由插入尾部 改为插入头部
     *
     * */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                cur.add(node.val);
                if (node.left != null) {
                    tmp.offer(node.left);
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                }
            }
            res.add(0,cur);
            Queue<TreeNode> helper = tmp;
            tmp = queue;
            queue = helper;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrderBottom(root);
    }


}
