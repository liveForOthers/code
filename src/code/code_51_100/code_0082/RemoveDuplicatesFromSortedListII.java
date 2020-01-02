package code.code_51_100.code_0082;

import code.code_1_50.common.ListNode;

public class RemoveDuplicatesFromSortedListII {

    /*
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     *
     * Example 1:
     *
     * Input: 1->2->3->3->4->4->5
     *
     * Output: 1->2->5
     *
     * Example 2:
     *
     * Input: 1->1->1->2->3
     *
     * Output: 2->3
     *
     * 目标： 删除有序链表中重复的所有元素，仅保留单个的元素
     *
     * 算法：
     * 1 伪头  缓存结果链表的前置节点
     * 2 缓存目标链表的最近一个删除的节点
     * 3 当前元素是否应该存入结果链表中 需要判断
     *   3.1 不在 最近删除的链表节点
     *   3.2 后置节点不与本节点值相同
     *
     *   存入后 更新 1 前置节点  2 最近删除的节点为null
     *   不存入 更新 1 最近删除的节点为本节点
     *
     * 时间复杂度 O(N) 空间复杂度：O(N)
     *
     * 缺点： 由于结果链表 增加节点时需要每次new一个新的节点，导致时间复杂度为O(1) 可以使用原地算法进行优化
     *
     * 优点： 不会改变入参头结点所代表的链表，程序安全性更好
     * */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        ListNode lastDeleteElement = null;
        ListNode cur = head;
        while (cur != null) {
            // 不在最近删除的链表节点
            if (lastDeleteElement != null && cur.val == lastDeleteElement.val) {
                cur = cur.next;
                continue;
            }
            // 后置节点与本节点值相同
            if (cur.next != null && cur.val == cur.next.val) {
                lastDeleteElement = cur;
                cur = cur.next;
                continue;
            }
            prev.next = new ListNode(cur.val);
            prev = prev.next;
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
        deleteDuplicates2(head);

    }

    /*
     * 使用原地算法进行优化
     * 算法：
     * 使用三指针： 结果链表 prev指针，当前节点指针，后继节点指针
     *
     * 1 使用快慢指针解决 当前节点是否应该删掉的问题
     * 2 使用标识节点标识 之前已删掉的节点
     *
     * 时间复杂度：O(N) 空间复杂度：O(1)
     *
     * */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode prev = dummyHead;
        ListNode lastDeleteElement = null;
        while (cur != null) {
            int compareVal1 = lastDeleteElement == null ? (cur.val - 1) : lastDeleteElement.val;
            int compareVal2 = next == null ? (cur.val - 1) : next.val;
            // 需要删除时 进行删除操作  并更新近期被删除的元素
            if (compareVal1 == cur.val || compareVal2 == cur.val) {
                lastDeleteElement = cur;
                prev.next = next;
                cur.next = null;
            }else{
                // 不删除元素时 更新prev
                prev = prev.next;
            }

            // 进行下一个元素的处理
            cur = next;
            next = next == null ? null : next.next;
        }
        return dummyHead.next;
    }
}
