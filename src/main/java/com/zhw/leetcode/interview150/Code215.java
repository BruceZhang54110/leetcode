package com.zhw.leetcode.interview150;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 */
public class Code215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));

    }

    public static int findKthLargest(int[] nums, int k) {
        int[] heap = nums;
        for (int i = (k-2)/2;  i>=0; i--) {
            sift(i, k-1, heap);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                sift(0, k-1, heap);
            }
        }
        return heap[0];

    }


    /**
     * 调整为小根堆
     */
    public static void sift(int low, int high, int[] arr) {
        int i = low;
        int j = 2 * i + 1; // 左孩子的下标
        int temp = arr[low]; // 根节点
        while (j <= high) { // 只要j位置有元素
            if ((j+1) <= high && arr[j] > arr[j+1]) {
                j = j+1; // 如果右孩子比左孩子小，那么指向右孩子
            }
            if (temp > arr[j]) {
                arr[i] = arr[j];
                i = j;
                j = 2*i+1;
            } else {
                arr[i] = temp;
                break;
            }

        }
        arr[i] = temp;

    }
}
