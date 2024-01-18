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

    /**
     * 反转链表方法
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 定义一个前置的哑结点
        ListNode prev = new ListNode(-1);
        // 创建一个当前节点，指向头结点（首节点）
        ListNode curr = head;
        while (curr != null) {
            // 创建一个next节点指向 curr.next
            ListNode next = curr.next;
            // curr.next 指向 prev 进行反转
            curr.next = prev;
            // prev 指向 curr
            prev = curr;
            // curr 指向 next
            curr = next;
        }
        return prev;
    }

    static class ListNode {
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


