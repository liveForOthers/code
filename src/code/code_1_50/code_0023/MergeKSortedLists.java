package code.code_1_50.code_0023;

import code.code_1_50.common.ListNode;

public class MergeKSortedLists {

    /*
    * 使用分治法合并k个链表
    * 时间复杂度 n*log(k)
    * 本次code 以递归进行实现  可以优化 使用循环方式取代递归
    * 将多个链表从中间截断 直到 链表数目为1 进行返回  为2 进行合并 并返回  否则继续中间截断
    *
    * */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        // 处理单个节点的情况
        if (left == right) {
            return lists[left];
        }
        // 两个节点 进行merge 并返回 头结点
        if (left + 1 == right) {
            return doMerge(lists[left], lists[left + 1]);
        }
        int mid = left + ((right - left) >> 1);
        ListNode leftHead = merge(lists, left, mid);
        ListNode rightHead = merge(lists, mid + 1, right);
        return doMerge(leftHead, rightHead);
    }

    private ListNode doMerge(ListNode leftNode, ListNode rightNode) {
        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        ListNode leftHead = leftNode;
        ListNode rightHead = rightNode;
        while(leftHead!=null || rightHead!=null){
            int l1 = leftHead==null?Integer.MAX_VALUE:leftHead.val;
            int l2 = rightHead==null?Integer.MAX_VALUE:rightHead.val;
            int val = 0;
            if (l1<=l2){
                val = l1;
                leftHead = leftHead.next;
            }else{
                val = l2;
                rightHead = rightHead.next;
            }
            prev.next = new ListNode(val);
            prev = prev.next;
        }
        return dummyNode.next;
    }
}
