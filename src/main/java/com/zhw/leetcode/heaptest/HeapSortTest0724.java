package com.zhw.leetcode.heaptest;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSortTest0724 {
    public static void main(String[] args) {
        int arr[] = {6, 9, 7, 8, 5, 0, 1, 2, 4, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 向下调整
     * @param arr 数组列表
     * @param low 堆的根节点位置
     * @param high 堆的最后一个元素的位置
     */
    public static void sift(int[] arr, int low, int high) {
        int i = low;
        // 定义临时tmp 表示根节点的值，后续有合适的值会替换过来
        int tmp = arr[low];
        // 左孩子
        int j = 2 * i + 1;
        // 只要j节点有值
        while (j <= high) {
            // 如果有右孩子且右孩子比左孩子大，那么就指向右孩子
            if (j+1 <= high && arr[j+1] > arr[j]) {
                // 指向右孩子
                j = j + 1;
            }
            // 如果arr[j]比 tmp大，说明arr[j]可以往上放，所以放到父节点的位置
            if (arr[j] > tmp) {
                // 说明arr[j]可以往上放，所以放到父节点的位置
                arr[i] = arr[j];
                // 往下看一层
                i = j;
                j = i * 2 + 1;
            } else {
                // tmp 更大，把tmp放到i位置上
                arr[i] = tmp;
                break;
            }
        }
        // 把tmp 放到叶子结点上
        arr[i] = tmp;
    }

    public static void sort(int[] arr) {
        // 先创建堆，创建大根堆（升序排）
        int length = arr.length;
        // 找到最后一个非叶子节点，最后一个节点下标是length-1，设孩子节点为j，父亲节点就是j=(i-1)/2
        for (int i = (length-2)/2; i >=0; i--) {
            // i表示建堆时，调整的部分的根的位置
            sift(arr, i, length-1);
        }
        // 建堆 end
        // 逐个出数
        for (int i = length - 1; i>= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            sift(arr, 0, i-1);
        }
    }
}
