package code.code_101_150.code_143;

import code.code_1_50.common.ListNode;

public class ReorderList {

    /*
     *  Example 1:
     *  Given 1->2->3->4, reorder it to 1->4->2->3.
     *
     *  Example 2:、
     *  Given 1->2->3->4->5, reorder it to 1->5->2->4->3
     *  重排链表，
     *  算法：链表旋转一半， 两个链表 交替前进
     * */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 找到链表左中点  中点后面的链表进行旋转
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = reverse(slow.next);
        slow.next = null;
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        ListNode firstHead = head;
        while (firstHead != null && secondHead != null) {
            prev.next = firstHead;
            firstHead = firstHead.next;
            prev.next.next = secondHead;
            secondHead = secondHead.next;
            prev = prev.next.next;
        }
        if (firstHead != null) {
            prev.next = firstHead;
        }
    }

    private static ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        prev.next = node;
        ListNode next = node.next;
        while (next != null) {
            node.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = node.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);
        head.next = null;
    }
}
