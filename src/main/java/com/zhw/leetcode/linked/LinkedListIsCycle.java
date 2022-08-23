package com.zhw.leetcode.linked;

import com.zhw.leetcode.home.Test.MyLinkedList;
import com.zhw.leetcode.home.Test.SingleLinked;
import com.zhw.leetcode.home.top100.AddTwoNumbers;

/**
 * 双指针判断链表是否有环
 */
public class LinkedListIsCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 快慢两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // 慢指针每次走一步
            slow = slow.next;
            // 快指针每次走两步
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

    }
}
