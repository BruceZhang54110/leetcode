package com.zhw.leetcode.linked;


/**
 * 反转链表二
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *  
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ReverseBetween {

    public ListNode reverse(ListNode head, int left, int right) {

        // 创建虚拟头结点，避免复杂分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第1步：从虚拟节点开始走left-1步，来到left的前一个节点
        for (int i = 0; i < left -1; i++) {
            pre = pre.next;
        }
        // 第2步：从pre节点开始走，走到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 第3步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 注意:切断链接
        pre.next = null;
        rightNode.next = null;
        // 反转链表子区间
        reverseLinkedList(leftNode);

        // 接回原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;

    }

    /**
     * 反转链表
     * @param head
     */
    public static void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
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
}
