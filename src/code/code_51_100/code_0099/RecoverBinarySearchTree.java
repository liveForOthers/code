package code.code_51_100.code_0099;

import code.common.TreeNode;

public class RecoverBinarySearchTree {

    /*
    * Two elements of a binary search tree (BST) are swapped by mistake.
    *
    * Recover the tree without changing its structure.
    *
    * Example 1:
    *
    * Input: [1,3,null,null,2]
    *
    *   1
    *  /
    * 3
    *  \
    *   2
    *
    * Output: [3,1,null,null,2]
    *
    *   3
    *  /
    * 1
    *  \
    *   2
    *
    * Example 2:
    *
    * Input: [3,1,4,null,null,2]
    *
    *   3
    *  / \
    * 1   4
    *    /
    *   2
    *
    * Output: [2,1,4,null,null,3]
    *
    *   2
    *  / \
    * 1   4
    *    /
    *   3
    *
    * Follow up:
    *
    * A solution using O(n) space is pretty straight forward.
    *
    * Could you devise a constant space solution?
    *
    * 目标：找出给定树中 位置互相错误的两个节点 并进行交换 使树恢复为二叉查找树
    *      空间复杂度要求 常量空间
    *
    * 算法：
    * 1 暴力法：中序遍历 找出不满足升序的两个节点 交换value即可 时间复杂度 O(N) 空间复杂度 O(N)
    *
    * 好多题解都是给的 使用中序遍历来找到 应该交换位置的 前后两节点  但是都没有达到常量空间复杂度
    * https://www.cnblogs.com/springfor/p/3891390.html
    * https://www.bilibili.com/video/av74697184?zw
    *
    * TODO 之后再code吧
    *
    * */
    public void recoverTree(TreeNode root) {

    }
}
