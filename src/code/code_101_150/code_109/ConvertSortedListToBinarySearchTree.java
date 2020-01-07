package code.code_101_150.code_109;

import code.code_1_50.common.ListNode;
import code.common.TreeNode;

public class ConvertSortedListToBinarySearchTree {

    /*
    * Given a singly linked list where elements are sorted in ascending order,
    * convert it to a height balanced BST.
    *
    * For this problem, a height-balanced binary tree is defined as a binary tree
    * in which the depth of the two subtrees of every node never differ by more than 1.
    *
    * 目标：将有序链表转为 平衡查找二叉树
    *
    * 算法：
    * 与有序数组差别为 有序链表如何实现二分查找找到中间节点
    * 节点中先存储链表节点位置  构建完树后 再根据位置更新其值
    *
    * 需要遍历三遍
    * 1 遍历链表求出 size
    * 2 递归创建出每个节点
    * 3 遍历树 对数的size进行赋值（中序遍历，节点值顺序就是 链表值顺序）
    *
    * 时间复杂度：O(N)  空间复杂度：O(logN) 递归树的高度次
    *
    * 学习：
    * 1 暴力法解决，通过快慢指针找到链表中的根节点，递归构建树  时间复杂度：O(NlogN) 空间复杂度：O(logN) 递归树的高度次
    * 2 转化为有序数组转树，将链表转为树 再进行构建树  时间复杂度：O(N) 空间复杂度：O(N)  典型的空间换时间
    * 3 模拟中序遍历，是已想到的算法的升级，不用构建树完毕再中序遍历赋值，
    *   直接使用中序遍历 边构建边赋值即可，减少最后一次赋值遍历的时间消耗
    *   时间复杂度：O(N) 空间复杂度：O(logN)
    *
    * TODO coding
    * */
    public TreeNode sortedListToBST(ListNode head) {
        throw new IllegalArgumentException("待code");
    }
}
