package code.code_101_150.code_145;

import code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    List<Integer> res = new ArrayList<>();

    /*
     * 要求：左右根 迭代
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }

    /*
     * 要求：使用迭代模拟递归过程
     * 分析递归过程：
     * 1 先处理最左 左处理完后 处理最左的右  最后处理根
     * 2 找到最左节点  左右子都没了把父节点加到结果中否则把父塞回栈中
     *
     * TODO 学习： 官网解法 迭代使用BFS一层一层打印 处理根节点时将左右孩子入栈
     * TODO       由于左右根顺序，插入时头插链表集合 反转顺序
     *
     * TODO coding
     * */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();


        return res;

    }
}
