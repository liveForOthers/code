package code.code_101_150.code_106;

import code.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /*
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     *
     * Note:
     *
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * inorder = [9,3,15,20,7]
     *
     * postorder = [9,15,7,20,3]
     *
     * Return the following binary tree:
     *   3
     *  / \
     * 9  20
     *   /  \
     *  15   7
     *
     * 目标：给定 中序遍历以及后序遍历 构建树
     * 算法：类似 前一个题目 不再赘述
     *
     * */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }
        return doBuildTree(cache, inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    private static TreeNode doBuildTree(Map<Integer, Integer> cache, int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        TreeNode res = new TreeNode(postorder[postorderRight - 1]);
        Integer curRootIndex = cache.get(postorder[postorderRight - 1]);
        if (curRootIndex == null) {
            throw new IllegalArgumentException("参数异常");
        }
        int leftCount = curRootIndex - inorderLeft;
        res.left = doBuildTree(cache, inorder, postorder, inorderLeft, curRootIndex, postorderLeft, postorderLeft + leftCount);
        res.right = doBuildTree(cache, inorder, postorder, curRootIndex + 1, inorderRight, postorderLeft + leftCount, postorderRight - 1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
}
