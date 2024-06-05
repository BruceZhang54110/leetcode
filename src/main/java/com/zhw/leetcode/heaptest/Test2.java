package com.zhw.leetcode.heaptest;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
    }


    /**
     * 向下调整
     * @param arr 存放数组
     * @param low 根节点
     * @param high 末尾节点
     */
    public static void sift(int[] arr, int low, int high) {
        int i = low;
        int j = 2 * i + 1; // 左孩子
        int tmp = arr[low];
        while (j <= high) {
            if ((j+1) <= high && arr[j+1] > arr[j]) {
                j = j + 1;
            }
            if (arr[j] > tmp) {
                arr[i] = arr[j];
                i = j;
                j = 2 * i + 1;
            } else {
                arr[i] = tmp;
                break;
            }
        }
        arr[i] = tmp;
    }

    /**
     * 排序过程
     * @param arr
     */
    public static void sort(int[] arr) {
        // 构造堆
        int length = arr.length;
        for (int i = (length-1-1)/2; i >= 0; i--) {
            sift(arr, i, length - 1);
        }
        // 出数
        for (int i = length - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            sift(arr, 0, i-1);
        }
    }
}
