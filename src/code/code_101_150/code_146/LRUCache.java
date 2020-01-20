package code.code_101_150.code_146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /*
     * Design and implement a data structure for Least Recently Used (LRU) cache.
     * It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key
     * if the key exists in the cache, otherwise return -1.
     * 如果key存在返回对应value  否则返回-1
     * put(key, value) - Set or insert the value if the key is not already present.
     * 插入或更新key对应的value，如果key已经存在了
     * When the cache reached its capacity,
     * it should invalidate the least recently used item before inserting a new item.
     * 当缓存容量满时，在插入一个新数据之前应该将最近最少使用的数据删除
     * The cache is initialized with a positive capacity.
     * 容量是正数
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     * 保证每一个操作都是O(1) 时间复杂度
     *
     * 算法：
     * map+ 链表
     * map保证O(1) 查找时间复杂度 value为链表节点对象
     * 链表提升节点删除，插入性能  保证修改O(1) 时间复杂度
     *
     * TODO bugFree
     * */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //删除原节点 并移动到头部
        remove(node);
        addHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        // 已存在，执行更新 删除原节点 并移动到头部
        if (node != null) {
            node.val = value;
            remove(node);
            addHead(node);
            return;
        }
        // 未存在 执行插入 加入map中 超容量，删尾巴加头  未超容量 直接加头
        if (cache.size() == this.capacity) {
            this.cache.remove(tail.key);
            remove(tail);
        }
        Node newNode = new Node(key, value);
        this.cache.put(newNode.key, newNode);
        addHead(newNode);
    }

    private void remove(Node node) {
        if (node == null) {
            return;
        }
        // 解绑前驱  解绑后继 本节点引用解除  头尾节点特殊处理
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = node.next;
        }
        if (node == tail) {
            tail = node.prev;
        }
    }

    private void addHead(Node node) {
        if (node == null) {
            return;
        }
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    Map<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;

    class Node {
        Node prev;
        Node next;
        int val;
        int key;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
