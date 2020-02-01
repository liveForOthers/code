package code.code_201_250.code_206;

import code.code_1_50.common.ListNode;

public class ReverseLinkedList {

    /*
     * 单链表反转
     * 三指针法
     * 时间复杂度: O(N) 空间复杂度：O(1)
     * */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = cur.next;
        }
        return dummyHead.next;
    }

}
