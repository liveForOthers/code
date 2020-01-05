package code.code_51_100.code_0100;

import code.common.TreeNode;

public class SameTree {

    /*
     * 判断两个树 是否一样
     * 一样标准：
     * 1 结构一致
     * 2 节点值一致
     *
     * 算法：
     * 递归比较结构与值
     *
     * 时间复杂度：O(N) 空间复杂度O(N)
     * */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
