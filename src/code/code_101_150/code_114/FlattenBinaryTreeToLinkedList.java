package code.code_101_150.code_114;

import code.common.TreeNode;

public class FlattenBinaryTreeToLinkedList {


    /*
     * Given a binary tree, flatten it to a linked list in-place.
     *
     * For example, given the following tree:
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     *
     * The flattened tree should look like:
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     *
     * 目标： 将给定树转为前序遍历 对应的链表  根->左->右
     *
     * 算法：
     * 对树执行前序遍历，边遍历 边处理节点左右指针
     * 时间复杂度: O(N) 空间复杂度:O(1)
     *
     * */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
                continue;
            }
            // 左孩子不为null 更新 right
            TreeNode right = cur.right;
            cur.right = cur.left;
            cur.left = null;
            TreeNode left = cur.right;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        flatten(root);
        System.out.println(root);
    }
}
