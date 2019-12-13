package code.code_0024;

import code.common.ListNode;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = swapPairs(head);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /*
    *  简单的链表题目   注意循环式 各个指针的变换交替
    * */
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        prev.next = head;
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        while (firstNode != null && secondNode != null) {
            ListNode nextFirstNode = secondNode.next;
            secondNode.next = firstNode;
            prev.next = secondNode;
            firstNode.next = nextFirstNode;
            prev = firstNode;
            firstNode = nextFirstNode;
            if (firstNode == null) {
                break;
            }
            secondNode = firstNode.next;
        }
        return dummyHead.next;
    }
}
