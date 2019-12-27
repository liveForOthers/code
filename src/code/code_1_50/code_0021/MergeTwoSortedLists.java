package code.code_1_50.code_0021;

import code.code_1_50.common.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null || p2 != null) {
            int val1 = p1 != null ? p1.val : Integer.MAX_VALUE;
            int val2 = p2 != null ? p2.val : Integer.MAX_VALUE;
            int cur = 0;
            if (val1 < val2) {
                cur = val1;
                p1 = p1.next;
            } else {
                cur = val2;
                p2 = p2.next;
            }
            prev.next = new ListNode(cur);
            prev = prev.next;
        }
        return dummyNode.next;
    }
}
