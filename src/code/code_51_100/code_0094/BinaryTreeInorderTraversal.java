package code.code_51_100.code_0094;

import code.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    /*
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * Example:
     * Input: [1,null,2,3]
     * 1
     *  \
     *   2
     *  /
     * 3
     *
     * Output: [1,3,2]
     *
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     *
     * 目标：矩阵的中序遍历
     *
     * 算法：
     * 1 迭代实现
     * 2 递归实现
     * */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        doInorderTraversal(res, root);
        return res;
    }

    private static void doInorderTraversal(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        // 先处理左侧节点
        doInorderTraversal(res, node.left);
        // 处理当前根节点
        res.add(node.val);
        // 处理右侧节点
        doInorderTraversal(res, node.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        inorderTraversal2(node);
    }

    /*
     * 使用迭代实现中序遍历
     *
     * */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            // 把node左孩子压入栈中
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 此时栈顶为最左孩子节点 栈顶出栈
            node = stack.pop();
            res.add(node.val);
            // 处理当前节点的右侧节点
            node = node.right;
        }
        return res;
    }
}
