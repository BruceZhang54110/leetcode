package com.zhw.leetcode.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 */
public class Code146 {

    /**
     * cache
     * value是链表节点
     */
    private Map<Integer, DlinkedNode> cache = new HashMap<>();

    /**
     * 链表元素个数
     */
    private int size;

    /**
     * 缓存容量
     */
    private int capacity;

    /**
     * 头结点
     */
    private DlinkedNode head;

    /**
     * 尾节点
     */
    private DlinkedNode tail;


    /**
     * 双向链表
     */
    class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;

        public DlinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DlinkedNode() {
        }
    }

    /**
     * 插入到头结点，也就是插入到伪头结点的后面
     * @param node
     */
    private void addToHead(DlinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

    }

    /**
     * 移除节点
     * @param node
     */
    private void removeNode(DlinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 移动到头部
     * @param node
     */
    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 移除尾端节点，就是移除伪尾节点的前一个
     * @return
     */
    private DlinkedNode removeTail() {
        DlinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    /**
     * 构造函数初始化双链表
     * @param capacity
     */
    public Code146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪装头部和伪装尾部节点
        this.head = new DlinkedNode();
        this.tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 存在。通过hash表定位，再移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            DlinkedNode newNode = new DlinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 超过容量，删除双向链表尾部节点
                DlinkedNode tail = removeTail();
                // 删除hash表元素
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    public static void main(String[] args) {
        Code146 code146 = new Code146(2);
        code146.put(1, 1);
        code146.put(2, 1);
        code146.get(1);
        code146.put(3, 3);
        int i = code146.get(2);
        System.out.println(i);

    }
}
