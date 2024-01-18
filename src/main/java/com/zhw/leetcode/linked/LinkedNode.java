package com.zhw.leetcode.linked;

/**
 * 单链表
 */
public class LinkedNode {
    int val;
    LinkedNode next;
    LinkedNode() {}
    LinkedNode(int val) {
        this.val = val;
    }
    LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }
}
