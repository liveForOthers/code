package code.code_101_150.code_138;

public class CopyListWithRandomPointer {
    /*
     * A linked list is given such that each node contains an additional random pointer
     * which could point to any node in the list or null.
     *
     * Return a deep copy of the list.
     * 目标：返回该链表的深度拷贝
     * The Linked List is represented in the input/output as a list of n nodes.
     * Each node is represented as a pair of [val, random_index] where:
     *
     * val: an integer representing Node.val
     * random_index: the index of the node (range from 0 to n-1)
     * where random pointer points to, or null if it does not point to any node.
     *
     * 算法：
     * 1一次遍历在原节点间后加copy节点
     * origin1->copy1->origin2
     * 2二次遍历拷贝random
     * 3三次遍历拆分
     *
     * 时间复杂度：O(N) 空间复杂度：O(N)
     *
     * */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node origin = head;
        while (origin != null) {
            Node copyNode = new Node(origin.val);
            copyNode.next = origin.next;
            origin.next = copyNode;
            origin = origin.next.next;
        }
        origin = head;
        while (origin != null) {
            origin.next.random = origin.random == null ? null : origin.random.next;
            origin = origin.next.next;
        }
        Node res = head.next;
        origin = head;
        while (origin != null) {
            Node copy = origin.next;
            origin.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            origin = origin.next;
        }
        return res;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
