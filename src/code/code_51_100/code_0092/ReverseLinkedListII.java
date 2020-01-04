package code.code_51_100.code_0092;

import code.code_1_50.common.ListNode;

public class ReverseLinkedListII {

    /*
     * Reverse a linked list from position m to n. Do it in one-pass.
     *
     * Note: 1 ≤ m ≤ n ≤ length of list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     *
     * Output: 1->4->3->2->5->NULL
     *
     * 算法：三指针法
     * 时间复杂度 O(N) 空间复杂度O(1)
     *
     * 学习：官方给了一个递归解法，粗略看了下  因为带来了额外的空间复杂度没再实现了
     * */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        prev.next = head;
        int count = n - m;
        while (m-- != 1) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        ListNode next = cur.next;
        while (count != 0) {
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            count--;
            next = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseBetween(head, 2, 4);
    }
}
