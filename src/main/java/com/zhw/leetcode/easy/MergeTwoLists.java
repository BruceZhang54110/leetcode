package com.zhw.leetcode.easy;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 解题：
 * 首先是暴力解法，定义一个哑结点，用来开头，哑结点的next才是真正开始的节点。
 * 逐个比较大小，遇到更小的，哑结点的next就等于它，同时向后移动那个链表指针，移动哑结点指针继续下次循环
 * 暴力解法时间复杂度是O(M+N)
 */
public class MergeTwoLists {

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

    /**
     * 暴力解法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode baoLiMergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);

        ListNode preNode = prehead;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                preNode.next = list1;
                list1 = list1.next;
            } else {
                preNode.next = list2;
                list2 = list2.next;
            }
            preNode = preNode.next;
        }
        preNode.next =  list1 == null ? list2:list1;
        return prehead.next;

    }

    /**
     * 递归解法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }


    }
}
