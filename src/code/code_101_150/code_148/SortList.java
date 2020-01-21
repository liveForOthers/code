package code.code_101_150.code_148;

import code.code_1_50.common.ListNode;

public class SortList {
    /*
     * Sort a linked list in O(n log n) time using constant space complexity.
     * 使用O(n log n) 时间复杂度  常量空间复杂度 对链表排序，返回链表头
     *
     * 递归：通过找到中点，将链表一分为二、二分为四、四分为八，最终分成单节点时开始合并返回合并返回。。。
     *
     * todo 学习下迭代实现归并排序的思想
     * 归并本质是，将大集合 拆分成小集合再进行合并。因此用迭代实现此思想，减少空间复杂度，减少找中点的消耗
     * 第1次 将 01,23,45,67,89.....排序
     * 第2次 将 01 23,45 67,89 910.排序
     * 第3次 将 0123 4567，89 。。。排序
     * 直到第i次 将所有两侧全部排序 跳出循环
     * */
    public static ListNode sortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        return partitionMergeSort(head);
    }

    private static ListNode partitionMergeSort(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }

        ListNode midNode = findMid(head);
        ListNode head2 = midNode.next;
        midNode.next = null;
        ListNode leftHead = partitionMergeSort(head);
        ListNode rightHead = partitionMergeSort(head2);
        return doMerge(leftHead, rightHead);
    }

    private static ListNode doMerge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (head1 != null || head2 != null) {
            int val1 = head1 == null ? Integer.MAX_VALUE : head1.val;
            int val2 = head2 == null ? Integer.MAX_VALUE : head2.val;
            if (val1 < val2) {
                prev.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                prev.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            prev = prev.next;
        }
        return dummyHead.next;
    }

    private static ListNode findMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);

        ListNode listNode = sortList1(head);
        System.out.println(listNode);
    }
}
