package code.code_101_150.code_113;

import code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    /*
     * Given a binary tree and a sum,
     * find all root-to-leaf paths where each path's sum equals the given sum.
     *
     * Note: A leaf is a node with no children.
     *
     * 目标: 找出给定树中 和为sum的 所有路径节点值列表
     *
     * 算法：
     * 回溯法 dfs
     *
     * 时间复杂度: O(N)  空间复杂度: O(logN)
     * */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, new ArrayList<>(), root, sum);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> cur, TreeNode node, int sum) {
        if (node.right == null && node.left == null) {
            if (sum == node.val) {
                cur.add(node.val);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        sum = sum - node.val;
        if (node.left != null) {
            cur.add(node.val);
            dfs(res, cur, node.left, sum);
            cur.remove(cur.size() - 1);
        }
        if (node.right != null) {
            cur.add(node.val);
            dfs(res, cur, node.right, sum);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> lists = pathSum(root, 22);
        System.out.println(lists);

    }
}
