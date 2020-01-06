package code.code_101_150.code_105;

import code.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /*
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     *
     * You may assume that duplicates do not exist in the tree.
     * For example, given
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     *
     * Return the following binary tree:
     *   3
     *  / \
     * 9  20
     *   /  \
     *  15   7
     *
     * 目标：通过先序以及中序遍历 构建树
     *
     * 算法：
     * 通过根据先序遍历确定当前根节点，根据根节点值在中序遍历中找到根节点索引，
     * 索引左侧为左子树，索引右侧为右子树。
     * 左右递归构建树
     *
     * 时间复杂度：O(N^2) 空间复杂度：O(N)
     *
     * 学习：
     * 可优化点：中序遍历查找根节点索引时，可以使用缓存进行优化 提高查找时间复杂度到 O(1)
     * 时间复杂度：O(N) 空间复杂度：O(N)
     *
     * */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null
                || inorder == null
                || preorder.length != inorder.length
                || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }
        return doBuildTree(cache, preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private static TreeNode doBuildTree(Map<Integer, Integer> cache, int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft >= preorderRight) {
            return null;
        }
        int curRootValue = preorder[preorderLeft];
        int curRootIndex = findCurRootIndex(cache, inorder, curRootValue, inorderLeft, inorderRight);
        TreeNode res = new TreeNode(curRootValue);
        int leftCount = curRootIndex - inorderLeft;
        res.left = doBuildTree(cache, preorder, inorder, preorderLeft + 1, preorderLeft + 1 + leftCount, inorderLeft, curRootIndex);
        res.right = doBuildTree(cache, preorder, inorder, preorderLeft + 1 + leftCount, preorderRight, curRootIndex + 1, inorder.length);
        return res;
    }

    private static int findCurRootIndex1(int[] inorder, int value, int inorderLeft, int inorderRight) {
        for (int i = inorderLeft; i < inorderRight; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        throw new IllegalArgumentException("参数错误");
    }

    private static int findCurRootIndex(Map<Integer, Integer> cache, int[] inorder, int value, int inorderLeft, int inorderRight) {
        Integer res = cache.get(value);
        if (res == null) {
            throw new IllegalArgumentException("参数错误");
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
