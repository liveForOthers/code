package code.code_101_150.code_116;

import code.common.Node;

public class PopulatingNextRightPointersInEachNode {

    /*
     *
     * You are given a perfect binary tree where all leaves are on the same level,
     * and every parent has two children.
     * 给定一个完全二叉树，该树的所有叶子节点都在同一层次，并且每个父节点都有两个孩子节点
     *
     * Populate each next pointer to point to its next right node.
     * If there is no next right node, the next pointer should be set to NULL.
     *
     * 给每个节点设置好 next 右指针
     * 如果没有右侧节点 右指针指向null
     *
     * Initially, all next pointers are set to NULL.
     *
     * 初始化时，所有节点的next指针都指向null
     *
     * Follow up:
     *
     * You may only use constant extra space.
     * 只允许使用常量空间
     * Recursive approach is fine,
     * you may assume implicit stack space does not count as extra space for this problem.
     * 最好使用迭代的方法，递归方法产生的栈空间开销也可以忽略
     * Example 1:
     *
     * Input: root = [1,2,3,4,5,6,7]
     *
     * Output: [1,#,2,3,#,4,5,6,7,#]
     *
     * Explanation: Given the above perfect binary tree (Figure A),
     * your function should populate each next pointer to point to its next right node,
     * just like in Figure B. The serialized output is in level order as connected
     * by the next pointers, with '#' signifying the end of each level.
     *
     * Constraints:
     *
     * The number of nodes in the given tree is less than 4096.
     *
     * -1000 <= node.val <= 1000
     *
     * 算法：
     * 一层一层处理，处理当前次时 记录下次的左节点
     * 迭代、递归 实现
     * */
    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node parent = root;
        while (parent != null) {
            Node nextParent = parent.left;
            while (parent != null && parent.left != null) {
                parent.left.next = parent.right;
                if (parent.next != null) {
                    parent.right.next = parent.next.left;
                }
                parent = parent.next;
            }
            parent = nextParent;
        }
        return root;
    }

    public static void main(String[] args) {
        Node parent = new Node(1);
        parent.left = new Node(2);
        parent.right = new Node(3);
        parent.left.left = new Node(4);
        parent.left.right = new Node(5);
        parent.right.left = new Node(6);
        parent.right.right = new Node(7);
        connect(parent);
        System.out.println(parent);

    }
}
