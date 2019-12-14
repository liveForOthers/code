package code.code_0025;

import code.common.ListNode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode listNode = reverseKGroup(head, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    /*
    *  本算法属于链表翻转的扩展  在其基础上增加了 1 边界值问题 2 本次链表旋转结束依靠k值判定 3 一个链表分为多次旋转
    *
    *  本次AC 不足： 对链表旋转三指针生疏了
    *  在一次旋转中
    *  1 prev 不会变化
    *  2 cur 不会变化
    *  3 只有next 一直随着cur.next变化而变化
    * */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        //计算总长度
        int len = 1;
        ListNode prev = head;
        while (prev.next != null) {
            len++;
            prev = prev.next;
        }
        // 边界值判定
        if (k > len) {
            return head;
        }
        // 执行 reverseK
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        prev = dummyHead;
        int times = len / k;
        while (times != 0) {
            times--;
            ListNode cur = prev.next;
            ListNode next = cur.next;
            // 执行当前次旋转
            int count = k - 1;
            while (count-- != 0) {
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            // 更新下次旋转的三指针
            prev = cur;
        }
        return dummyHead.next;
    }
}
