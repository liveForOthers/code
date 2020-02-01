package code.code_201_250.code_203;

import code.code_1_50.common.ListNode;

public class RemoveLinkedListElements {


    /*
     * Remove all elements from a linked list of integers that have value val.
     * 从整数链表中移除值为val的所有元素
     * Example:
     * Input:  1->2->6->3->4->5->6, val = 6
     * Output: 1->2->3->4->5
     * 算法：
     * 伪头 移除即可
     * */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode node = dummyHead.next;
        ListNode prev = dummyHead;
        while (node != null) {
            if (node.val != val) {
                prev = prev.next;
                node = node.next;
                continue;
            }
            prev.next = node.next;
            node = node.next;
        }
        return dummyHead.next;
    }
}
