package code.code_51_100.code_0061;

import code.code_1_50.common.ListNode;

public class RotateList {

    /*
     * Input: 1->2->3->4->5->NULL, k = 2  Output: 4->5->1->2->3->NULL
     * Explanation:
     * rotate 1 steps to the right: 5->1->2->3->4->NULL
     * rotate 2 steps to the right: 4->5->1->2->3->NULL
     *
     * 目标： 将链表向右旋转k次 返回新的链表头
     *
     * 算法：
     *   1 计算出链表节点数
     *   2 将k 对节点数取余数，避免多余的遍历
     *   3 快指针先走k步
     *   4 快慢指针一起走 直到快指针到达尾巴
     *   5 使用快指针使尾巴与头相连
     *   6 使用慢指针 1 记录新头 2 将新尾巴和新头断开
     * */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0 || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode prev = head;
        ListNode cur = head;
        while (k != 0) {
            prev = prev.next;
            k--;
        }
        while (prev.next != null) {
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = head;
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        rotateRight(head, 7);
    }
}
