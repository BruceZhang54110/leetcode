package com.zhw.leetcode.heaptest;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度O(nlogn)
 */
public class Test1 {


    public static void main(String[] args) {
        int arr[] = {6,9,7,8,5,0,1,2,4,3,67,89,12,45,32,63,18,89,6666};
        long start = System.currentTimeMillis();
        sort(arr);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        // 1. 建堆
        // 找最后一个非孩子节点，如果孩节点下标是i ,则父亲节点下标是 (i-1)/2
        // (n-1-1)/2
        // (n-2)/2 =>  n/2-1
        for (int i = (length - 2) / 2; i >=0 ; i--) {
            // i 表示向下调整时的根节点的下标
            sift(i, length - 1, arr);
            // 建堆任务完成了
        }
        // 2. 出数
        for (int i = length - 1; i >= 0; i--) {
            // i 指向当前堆的最后一个元素
            // 堆顶元素和最后一个交换
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            // 出一个后，需要向下调整，让其满足堆的性质
            sift(0, i - 1, arr);
        }
    }

    /**
     * 调整
     *
     * @param low  堆的第一个元素
     * @param high 堆的最后一个元素
     * @param arr  堆的存放数组
     */
    public static void sift(int low, int high, int[] arr) {
        int i = low;
        int j = 2 * i + 1; // 左孩子的下标
        int tmp = arr[low]; // 把堆顶元素存起来
        while (j <= high) { // 只要j位置有元素
            if ( (j + 1) <= high && arr[j] < arr[j + 1]) {
                j = j + 1; // 如果右孩子比左孩子大，j指向右孩子
            }
            if (arr[j] > tmp) {
                arr[i] = arr[j]; // arr[j] 孩子节点的值比tmp大，把tmp放到arr[i]的位置上
                i = j; // 往下看一层
                j = 2 * i + 1;
            } else {
                arr[i] = tmp;
                break;
            }
        }
        arr[i] = tmp;
    }

}
