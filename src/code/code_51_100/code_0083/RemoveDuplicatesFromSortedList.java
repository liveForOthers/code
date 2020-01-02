package code.code_51_100.code_0083;

import code.code_1_50.common.ListNode;

public class RemoveDuplicatesFromSortedList {

    /*
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     *
     * Example 1:
     * Input: 1->1->2
     * Output: 1->2
     *
     * Example 2:
     *
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     *
     * 与上一题目不同的是  上次是 删除所有出现大于1次的元素
     *
     * 本次是 使出现大于1次的元素 仅出现一次
     *
     * 算法：
     * 比较 prev.val  以及  cur.val  不相等执行插入 否则处理下一个
     *
     * 时间复杂度:O(N) 空间复杂度:O(1)
     * */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(head.val - 1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        head.next.next.next = new ListNode(3);

        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        deleteDuplicates(head);
    }
}
