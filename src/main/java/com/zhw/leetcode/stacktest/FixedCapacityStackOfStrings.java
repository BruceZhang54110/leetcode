package com.zhw.leetcode.stacktest;

/**
 * 固定容量的智能放String 的栈
 */
public class FixedCapacityStackOfStrings {

    /**
     * entries
     */
    private String[] a;
    /**
     * size
     */
    private int n;

    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    /**
     * 入栈操作
      * @param item
     */
    public void push(String item) {
        a[n++] = item;
    }

    /**
     * 出栈操作
     * @return
     */
    public String pop() {
        return a[--n];
    }




}
