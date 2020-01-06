package code.code_101_150.code_102;

import code.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {


    /*
    * Given a binary tree, return the level order traversal of its nodes' values.
    * (ie, from left to right, level by level).
    *
    * For example:
    *
    * Given binary tree [3,9,20,null,null,15,7],
    *
    * return its level order traversal as:
    * [[3],[9,20],[15,7]]
    *
    * 目标：返给给定树的层序遍历
    * 算法：
    * 队列一层一层缓存实现
    *
    * 时间复杂度：O(N) 空间复杂度：O(N)
    *
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> curLevel = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left!=null){
                    next.offer(node.left);
                }
                if (node.right!=null){
                    next.offer(node.right);
                }
            }
            res.add(curLevel);
            Queue<TreeNode> tmp = next;
            next = queue;
            queue = tmp;
        }
        return res;
    }
}
