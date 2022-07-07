package com.zhw.leetcode.home.Test;

public class SingleLinked<T> {

    private Node first;

    private int size = 0;


    public class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node(T item) {
            this.item = item;
        }
    }

    /**
     * 在链表头部添加元素
     * @param t
     */
    public void addFirst(T t) {
      this.first = new Node(t, this.first);
      this.size++;
    }

    public void add(int index, T t) {
        if (!isPositionIndex(index)) {
            throw new IllegalArgumentException("index error");
        }
        if (index == size) {
            // 添加到尾部
            int i = 0;
            Node firstNode = this.first;
            while (i <= index) {
                firstNode = firstNode.next;
                    i++;
            }
            Node node = new Node(t);
            firstNode.next = node;
        } else if (index == 0) {
            addFirst(t);

        } else {
            // 插到中间位置
            Node  newNode = new Node(t);
            int position = 0;
            Node cur = this.first; // 标记当前节点
            Node pre = null; // 记录前置节点
            while (cur != null) {
                if (position == index) {
                    newNode.next = cur;
                    pre.next = newNode;
                    return;
                }
                pre = cur;
                cur = cur.next;
                position++;
            }
        }

    }

    /**
     * 判断index 是否合法
     * @param index
     * @return
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    public Node<T> getNode(int index) {
        if (!isPositionIndex(index)) {
            throw new IllegalArgumentException("index error");
        }
        Node cur = this.first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

}
