package code.code_101_150.code_117;

import code.common.Node;

public class PopulatingNextRightPointersInEachNodeII {

    /*
     * 大体和之前要求一样
     * 本次不能保证为完美二叉树
     *
     * TODO 递归解法
     * */
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node parent = root;
        while (parent != null) {
            Node nextParent = null;
            while (nextParent == null && parent != null) {
                if (parent.left == null && parent.right == null) {
                    parent = parent.next;
                    continue;
                }
                nextParent = parent.left == null ? parent.right : parent.left;
            }
            Node prev = nextParent;
            while (parent != null) {
                if (parent.left == prev) {
                    if (parent.right != null) {
                        prev.next = parent.right;
                        prev = parent.right;
                    }
                } else if (parent.right == prev) {
                } else {
                    if (parent.left != null) {
                        prev.next = parent.left;
                        prev = prev.next;
                    }
                    if (parent.right != null) {
                        prev.next = parent.right;
                        prev = prev.next;
                    }
                }
                parent = parent.next;
            }
            parent = nextParent;
        }
        return root;
    }

    public static void main(String[] args) {
        Node parent = new Node(1);
        parent.right = new Node(3);
        connect(parent);
        System.out.println(parent);

    }
}
