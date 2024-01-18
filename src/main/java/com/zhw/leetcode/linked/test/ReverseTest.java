package com.zhw.leetcode.linked.test;

public class ReverseTest {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        ListNode listNode = reverseList(node1);
        while (listNode!= null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    private static ListNode reverseList(ListNode node) {
        ListNode reverseList = null;
        while (node != null) {
            ListNode tmp = node;
            node = node.next;
            tmp.next = reverseList;
            reverseList = tmp;
        }
        return reverseList;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
