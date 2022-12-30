package com.zhw.leetcode.linked;

/**
 * 反转链表
 */
public class ReverseList1 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(2);
        head.next = listNode;
        ListNode listNode1 = reverseList(head);
        while(listNode1 !=null) {
            System.out.print(listNode1.val + "->");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(-1);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
