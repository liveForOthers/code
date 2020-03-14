package code.code_1_50.code_0025;

import code.code_1_50.common.ListNode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = new ReverseNodesInKGroup().reverseKGroup2(head, 2);
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
    public static ListNode reverseKGroup1(ListNode head, int k) {
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

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // 伪头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 前继节点 头结点 尾巴节点  尾巴节点待初始化
        ListNode prev = dummyHead;
        ListNode curHead = head;
        ListNode curTail = prev;
        // 遍历列表
        while (curHead != null) {
            // 1 找当前段尾巴节点 不足k个 快速结束
            int count = k;
            while(curTail != null && count != 0) {
                curTail = curTail.next;
                count--;
            }
            if (curTail == null) {
                break;
            }
            // 2 反转本段
            reverse(prev, curHead, curTail);
            // 3 更新 前继节点 头结点
            prev = curHead;
            curHead = prev.next;
            curTail = prev;
        }
        // 返回伪头结点
        return dummyHead.next;
    }

    private void reverse(ListNode prevNode, ListNode head, ListNode tail){
        ListNode endNode = tail.next;
        while (head.next != endNode) {
            ListNode nextNode = head.next;
            head.next = nextNode.next;
            nextNode.next = prevNode.next;
            prevNode.next = nextNode;
        }
    }
}
