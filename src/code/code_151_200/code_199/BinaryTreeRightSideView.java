package code.code_151_200.code_199;

import code.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    /*
     * Given a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.
     *
     * Example:
     *
     * Input: [1,2,3,null,5,null,4]
     * Output: [1, 3, 4]
     * Explanation:
     *       1            <---
     *     /   \
     *    2     3         <---
     *     \     \
     *      5     4       <---
     * 算法：
     * 层序遍历
     * 时间复杂度：O(N) 空间复杂度：O(logN)
     *
     * todo 学习dfs实现方法 存储最大层次 以及 各个层次对应节点值的方法实现，占用空间更多但也不失为一种方法 https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/er-cha-shu-de-you-shi-tu-by-leetcode/
     *
     * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (queue.isEmpty()) {
                    res.add(node.val);
                }
                if (node.left!=null){
                    next.offer(node.left);
                }
                if (node.right!=null){
                    next.offer(node.right);
                }
            }
            Queue<TreeNode> tmp = queue;
            queue = next;
            next = tmp;
        }
        return res;
    }


}
