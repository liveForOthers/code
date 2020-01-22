package code.code_151_200.code_160;

import code.code_1_50.common.ListNode;

public class IntersectionOfTwoLinkedLists {

    /*
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     * 有相交点返回相交节点  无则返回null
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int length1 = 0;
        ListNode nodeA = headA;
        while (nodeA != null) {
            length1++;
            nodeA = nodeA.next;
        }
        int length2 = 0;
        ListNode nodeB = headB;
        while (nodeB != null) {
            length2++;
            nodeB = nodeB.next;
        }
        int diff = Math.abs(length1 - length2);
        nodeA = headA;
        nodeB = headB;
        ListNode prevNode = length1 > length2 ? nodeA : nodeB;
        while (diff != 0) {
            diff--;
            prevNode = prevNode.next;
        }
        if (length1 > length2) {
            nodeA = prevNode;
        } else {
            nodeB = prevNode;
        }
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}
