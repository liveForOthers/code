package code.code_0019;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        removeNthFromEnd(new ListNode(1), 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (n>len){
            n = n % len;
        }
        ListNode prev = dummyHead;
        ListNode slow = dummyHead;
        while (n != 0) {
            prev = prev.next;
            n--;
        }
        while (prev.next != null) {
            prev = prev.next;
            slow = slow.next;
        }
        ListNode next = null;
        if (slow.next != null) {
            next = slow.next.next;
        }
        slow.next = next;
        return dummyHead.next;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
