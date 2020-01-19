package code.code_101_150.code_142;

import code.code_1_50.common.ListNode;

public class LinkedListCycleII {

    /*
     * 环形链表 返回环交点链表节点
     * */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != slow) {
            return null;
        }
        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;
        detectCycle(head);
    }
}
