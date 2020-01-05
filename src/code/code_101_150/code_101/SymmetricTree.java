package code.code_101_150.code_101;

import code.common.TreeNode;

public class SymmetricTree {
    /*
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *
     * 目标：判断给定树是否左右对称
     *
     * 算法：
     * 类似判断两个树相同  递归处理
     *
     * 时间复杂度：O(N)  空间复杂度：O(N)
     *
     *
     * 学习：官方题解中给出使用两个队列进行bfs 迭代处理  后期可以code下
     * */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doVerifySymmetric(root.left, root.right);
    }

    private boolean doVerifySymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return doVerifySymmetric(left.left, right.right) && doVerifySymmetric(left.right, right.left);
    }
}
