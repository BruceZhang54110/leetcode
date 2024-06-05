package com.zhw.leetcode.interview150;

/**
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：
 * 1. nums1.length == m + n
 * 2. nums2.length == n
 * 3. 0 <= m, n <= 200
 * 4. 1 <= m + n <= 200
 * 5. -109 <= nums1[i], nums2[j] <= 109
 * <p>
 *     示例 1：
 *     输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 *     输出：[1,2,2,3,5,6]
 *   解题思路：
 *   使用双指针法，从后向前遍历，nums1和nums2的元素，谁更大，谁就放到nums1末尾，逐渐从后向前放置。
 *   如果需要nums1或者nums2下标遍历结束，则选取另一个数组元素放置。
 */
public class Code88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 4, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    /**
     * 合并方法
     * @param nums1 数组1
     * @param m 数组1的元素个数
     * @param nums2 数组2
     * @param n 数组2的元素个数
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = nums1.length - 1;
        int curr;
        while (p1 > -1 && p2 > -1) {
            if (p1 == -1) {
                curr = nums2[p2--];
            } else if (p2 == -1) {
                curr = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                curr = nums1[p1--];
            } else {
                curr = nums2[p2--];
            }
            nums1[p--] = curr;
        }

    }
}
