package com.zhw.leetcode.linked;

/**
 * 反转链表
 */
public class ReverseListTest {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = node1;
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println();
        System.out.println("无头结点的反转后：");
        // 反转单链表
        ListNode tmp = node1;

        ListNode reverseListNode = reverseList(tmp);
        ListNode reverseListNode1 = reverseListNode;
        while (reverseListNode1 != null) {
            System.out.print(reverseListNode1.val + ", ");
            reverseListNode1 = reverseListNode1.next;
        }
        ListNode head = new ListNode(-1, reverseListNode);
        // 头结点
        reverseList2(head);
        System.out.println();
        System.out.println("使用带头结点的再次反转后：");
        // 反转单链表
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 不带头结点的反转链表
     * @param node
     * @return
     */
    private static ListNode reverseList(ListNode node) {
        ListNode reverseNode = null;
        while(node!= null) {
            ListNode tmp = node;
            node = node.next;
            tmp.next = reverseNode;
            reverseNode = tmp;
        }
        return reverseNode;
    }

    private static ListNode reverseNodeTest1111(ListNode node) {
        ListNode reverseNode = null;
        while (node != null) {
            ListNode tmp = node;
            node = node.next;
            tmp.next = reverseNode;
            reverseNode = tmp;
        }
        return reverseNode;
    }

    /**
     * 带有头结点的原地反转,不借助额外的节点
     * @param head
     * @return
     */
    private static void reverseList2(ListNode head) {
        ListNode beg = head.next;
        ListNode end = head.next.next;
        while (end != null) {
            beg.next = end.next;
            end.next = head.next;
            head.next = end;
            end = beg.next;
        }
    }


    /**
     * 头插法反转链表
     * @param head
     */
    public static void reverseList3(ListNode head) {
        ListNode p = head.next;
        head.next = null;
        while (p!= null) {
            ListNode q = p.next;
            p.next = head.next;
            head.next = p;
            p = q;
        }
    }

    private static class ListNode {
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
}


