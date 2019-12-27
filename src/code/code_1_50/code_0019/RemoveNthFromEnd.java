package code.code_1_50.code_0019;

import code.code_1_50.common.ListNode;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        removeNthFromEnd(new ListNode(1), 1);
    }

    /*
     *  1 对于链表  建立伪头
     *  2 求出长度
     *  3 n超出长度时 取余  注意1%1==0
     *  4 处理节点删除  如删除的为尾巴节点 要将尾巴前一个节点next置null
     *
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (n > len) {
            n = n % len;
        }
        ListNode prev = dummyHead;
        ListNode slow = dummyHead;
        while (n != 0) {
            prev = prev.next;
            n--;
        }
        while (prev.next != null) {
            prev = prev.next;
            slow = slow.next;
        }
        ListNode next = null;
        if (slow.next != null) {
            next = slow.next.next;
        }
        slow.next = next;
        return dummyHead.next;
    }


}
