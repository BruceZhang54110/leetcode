package com.zhw.leetcode.home.Test;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

}

public class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        if (index >= size) {
            return -1;
        }
        int currCount = 0;
        ListNode curr = head;
        while (currCount <= index) {
            curr = curr.next;
            currCount ++;
        }
        return curr.val;

    }

    public void addAtHead(int val) {
        addAtIndex(0, val);

    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ++size;
        ListNode pred = head;
        for (int i = 0; i < index; ++i) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;

    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        if (index < 0) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; ++i) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */