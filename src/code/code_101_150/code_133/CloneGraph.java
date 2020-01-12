package code.code_101_150.code_133;

import java.util.*;

public class CloneGraph {


    /*
     * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
     * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
     *
     * 目标：给定一个无向连接图的节点的引用，返回该图的深度克隆
     * 每个节点有两个属性
     * 1 值 val
     * 2 邻居节点列表
     *
     * Note:
     * The number of nodes will be between 1 and 100.
     * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
     * Since the graph is undirected, if node p has node q as neighbor,
     * then node q must have node p as neighbor too.
     * You must return the copy of the given node as a reference to the cloned graph.
     *
     * 节点数目在1到100之间
     * 无向图是一个简单图，没有重复的边界，没有自旋
     * 由于图是无向的，如果节点p包含节点q作为邻居，则节点q也必然有p这个邻居
     * 返回克隆图中与给定节点对应的节点
     *
     * 算法：
     * 克隆当前节点，处理当前节点的邻居节点，再处理邻居节点的邻居节点
     * 要避免死循环 将处理完毕的节点存在map中  map为旧节点-新节点的映射关系
     *
     * 时间复杂度:O(N) 空间复杂度:O(N)
     * */
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> cache = new HashMap<>();
        Deque<Node> queue = new LinkedList<>();
        Node res = new Node(node.val);
        cache.put(node, res);
        queue.offer(node);
        // 队列中存储 val已克隆 但是邻居节点列表未克隆的节点
        while (!queue.isEmpty()) {
            Node oldNode = queue.poll();
            if (oldNode.neighbors == null) {
                continue;
            }
            for (Node cur : oldNode.neighbors) {
                Node newNodeNeighbor = cache.get(cur);
                if (newNodeNeighbor == null) {
                    // 克隆邻居节点
                    newNodeNeighbor = new Node(cur.val);
                    cache.put(cur, newNodeNeighbor);
                    queue.offer(cur);
                }
                cache.get(oldNode).neighbors.add(newNodeNeighbor);
            }
        }
        return res;
    }


    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors = new ArrayList<>();
        one.neighbors.add(two);
        one.neighbors.add(four);

        two.neighbors = new ArrayList<>();
        two.neighbors.add(one);
        two.neighbors.add(three);

        three.neighbors = new ArrayList<>();
        three.neighbors.add(two);
        three.neighbors.add(four);

        four.neighbors = new ArrayList<>();
        four.neighbors.add(one);
        four.neighbors.add(three);

        cloneGraph(one);
    }
}
