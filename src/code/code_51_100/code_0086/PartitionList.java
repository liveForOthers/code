package code.code_51_100.code_0086;

import code.code_1_50.common.ListNode;

public class PartitionList {

    /*
     * Given a linked list and a value x,
     * partition it such that all nodes less than x come before nodes greater than or equal to x.
     * 给定一个链表 和一直值，将链表分片使 小于x的值的节点 在 大于等于x的值的节点的 前面。如果两个节点满足小于或大于等于x，则保持原有顺序
     *
     * You should preserve the original relative order of the nodes in each of the two partitions.
     *
     * Example:
     *
     * Input: head = 1->4->3->2->5->2, x = 3
     *
     * Output: 1->2->2->4->3->5
     *
     * 算法：
     * 两个伪头 一个小头节点 一个大头结点
     * 遍历完链表后 小头尾巴链接大头  大头尾巴指向null
     *
     * 时间复杂度：O(N) 空间复杂度：O(1) 使用原地算法 实现O(1)空间复杂度
     * */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyValueLessThanXHead = new ListNode(-1);
        ListNode dummyValueMoreThanOrEqualToXHead = new ListNode(-1);
        ListNode smallValuePrev = dummyValueLessThanXHead;
        ListNode bigValuePrev = dummyValueMoreThanOrEqualToXHead;
        ListNode cur = head;
        while(cur!=null){
            if (cur.val<x){
                smallValuePrev.next = cur;
                smallValuePrev = smallValuePrev.next;
            }else{
                bigValuePrev.next = cur;
                bigValuePrev = bigValuePrev.next;
            }
            cur = cur.next;
        }
        smallValuePrev.next = dummyValueMoreThanOrEqualToXHead.next;
        bigValuePrev.next = null;
        return dummyValueLessThanXHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        partition(head,3);
    }
}
