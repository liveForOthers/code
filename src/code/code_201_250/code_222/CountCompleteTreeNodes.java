package code.code_201_250.code_222;

import code.common.TreeNode;

public class CountCompleteTreeNodes {
    /*
     * 计算完全二叉树节点的个数
     * 完全二叉树除最后一层外是完美二叉树
     * 最后一层靠左满节点
     *
     * 算法：
     * 1 brute force
     * 递归遍历所有节点并计数
     * 时间复杂度:O(N) 空间复杂度:O(logN)
     *
     * 2 利用完全二叉树性质，完美二叉树的节点个数为 2^n-1
     * 获得左子树高度 left
     * 获得右子树高度 right
     * left==right  说明左子树是完美二叉树  递归处理右子树
     * left>right  说明右子树是完美二叉树  递归处理左子树
     * */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countHeight(root.left);
        int right = countHeight(root.right);
        if (left == right) {
            return (1 << left) + countNodes(root.right);
        }
        return (1 << right) + countNodes(root.left);
    }

    private int countHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int res = 1;
        while (node.left != null) {
            node = node.left;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);

        int i = new CountCompleteTreeNodes().countNodes(node);
        System.out.println(i);
    }
}
