package code.code_101_150.code_147;

import code.code_1_50.common.ListNode;

public class InsertionSortList {

    /*
     *
     * 使用传统插入排序 重新排序链表。时间复杂度O(N^2) 空间复杂度O(1)
     * */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = null;
        while (cur != null) {
            if (cur.val>=prev.val){
                prev = prev.next;
                cur = cur.next;
                continue;
            }
            next = cur.next;
            //找到cur节点的新前继节点
            ListNode newPrev = dummyHead;
            while (newPrev.next != null && newPrev.next.val < cur.val) {
                newPrev = newPrev.next;
            }
            //将cur在原位置解绑
            prev.next = cur.next;
            //将cur插入新位置
            cur.next = newPrev.next;
            newPrev.next = cur;
            //更新cur
            cur = next;
        }
        return dummyHead.next;
    }
}
