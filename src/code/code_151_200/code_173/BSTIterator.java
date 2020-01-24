package code.code_151_200.code_173;

import code.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {
    /*
     * 算法：
     * 1
     * 构造器  构建树的中序遍历，存入容器中，使用指针  或每次移除 进行迭代容器
     * 优点：求取next  以及 hasNext都能达到O(1)时间复杂度
     * 缺点：每次初始化时需要O(N)时间复杂度
     *
     * 2
     * 延迟next计算 在next时，找到合适元素， 此过程最差时间复杂度O(N) 平均时间复杂度O(h)
     * 如为平衡BST的话，next最差可以到O(h) 时间复杂度
     * 优点: 把时间复杂度平均到next中  而非直接全放在构造方法中
     * 缺点：next时间复杂度变高，且在非平衡BST时 稳定性差
     *
     * 本题以延迟next实现，构造器中序遍历法参考中序遍历算法即可
     *
     * todo 延迟next学习
     * */
    public BSTIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        leftToStack(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode res = stack.pop();
        if (res.right != null) {
            leftToStack(res.right);
        }
        return res.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    // 对象共享  多线程操作同一对象写时存在线程安全问题
    private Deque<TreeNode> stack;

    private void leftToStack(TreeNode node) {
        while (node != null) {
            this.stack.push(node);
            node = node.left;
        }
    }
}
