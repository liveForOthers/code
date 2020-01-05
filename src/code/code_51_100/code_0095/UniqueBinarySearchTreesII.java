package code.code_51_100.code_0095;

import code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    /*
     *
     * Given an integer n,
     * generate all structurally unique BST's (binary search trees) that store values 1 ... n.
     *
     * Example:
     * Input: 3
     * Output:
     * [[1,null,3,2],
     * [3,2,null,1],
     * [3,1,null,null,2],
     * [2,1,3],
     * [1,null,2,null,3]]
     * Explanation:
     * The above output corresponds to the 5 unique BST's shown below:
     * 1         3     3      2      1
     *  \       /     /      / \      \
     *   3     2     1      1   3      2
     *  /     /       \                 \
     * 2     1         2                 3
     *
     * 目标：给定1到n，n个数 生成所有二分查找树
     *
     * 算法：
     * 树的算法实现使用递归方便
     * dfs实现 每次选取一个节点 作为根节点 左右分别递归实现
     *
     * 学习：时间复杂度 空间复杂度计算 以及 二叉搜索树 与 卡特兰数
     * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode/
     * */
    public static List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<TreeNode> treeNodes = doGenerateTrees(1, n);
        return treeNodes;
    }

    private static List<TreeNode> doGenerateTrees(int begin, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (begin > end) {
            res.add(null);
            return res;
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> leftNodes = doGenerateTrees(begin, i - 1);
            List<TreeNode> rightNodes = doGenerateTrees(i + 1, end);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode curRoot = new TreeNode(i);
                    curRoot.left = leftNode;
                    curRoot.right = rightNode;
                    res.add(curRoot);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        generateTrees(3);
    }

}
