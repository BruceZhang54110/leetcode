package com.zhw.leetcode.lru;


import java.util.HashMap;
import java.util.Map;

public class LruTest {

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

    private DlinkedNode tail;



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
     * 添加到头结点，也就是插入到尾节点的后面
     */
    private void addToHead(DlinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DlinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DlinkedNode removeTail() {
        DlinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public LruTest(int capacity) {
        this.size = 0;
        this.capacity = capacity;
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
        // 存在，通过hash表定位，在移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            DlinkedNode newNode = new DlinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DlinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }


}
