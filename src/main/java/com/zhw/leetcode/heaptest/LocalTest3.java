package com.zhw.leetcode.heaptest;

import java.util.Arrays;

public class LocalTest3 {

    public static void main(String[] args) {
        int arr[] = {6,9,7,8,5,0,1,2,4,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 构造堆开始
        int length = arr.length;
       // 找最后一个非孩子节点，如果孩节点下标是i ,则父亲节点下标是 (i-1)/2
        // (n-1-1)/2
        // (n-2)/2 =>  n/2-1
        for(int i = length / 2 - 2; i >= 0; i--) {
            sift(i, length - 1, arr);
        }
        // 构造堆完成
        // 出数
        for (int i = length - 1; i >= 0; i--) {
            // 堆顶和最后一个交换
            int tmp = arr[i]; // 最大数
            arr[i] = arr[0];
            arr[0] = tmp;
            sift(0, i-1, arr);
        }

    }

    /**
     * 向下调整（除去根节点其他字节已经满足堆的性质）
     * @param low
     * @param high
     * @param arr
     */
    public static void sift(int low, int high, int[] arr) {
        int tmp = arr[low];
        int i = low;
        int j = 2 * i + 1;
        while (j <= high) {
            if (j+1 <= high && arr[j] < arr[j+1]) {
                // 左节点如果比右节点小，那么就选择右节点
                j = j+1;
            }
            if (tmp < arr[j]) {
                arr[i] = arr[j];
                // 往下看一层
                i = j;
                j = 2 * i + 1;
            } else {
                arr[i] = tmp;
                break;
            }
        }
        arr[i] = tmp;

    }
}
