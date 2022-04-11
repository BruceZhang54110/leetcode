package com.zhw.leetcode.home.top100;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteLastLinkedListNode {


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;

        ListNode listNode3 = new ListNode(3, null);

        ListNode listNode2 = new ListNode();
        listNode2.val = 2;
        listNode2.next = listNode3;
        listNode.next = listNode2;
        final ListNode result = removeNthFromEnd(listNode, 1);
        System.out.println(result.val);
        System.out.println(result.next.val);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dumy;
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dumy.next;
        return ans;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }


}

