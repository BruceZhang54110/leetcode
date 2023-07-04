package com.zhw.leetcode.sortmethod;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSortTest {

    public static void main(String[] args) {
        // 要求升序排序，构造大顶堆
        int[] arr = {4, 6, 8, 5, 9};
        sort(arr);
        System.out.println("数组=" + Arrays.toString(arr));
    }

    /**
     * 使用堆排序方法实现
     * @param arr
     */
    public static void sort(int arr[]) {

        // 将数组构造为大顶堆
        for (int i = arr.length / 2 -1 ; i >=0 ; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 交换
        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] =temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 将一个数组（二叉树）调整为一个大顶堆
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的下标
     * @param length 表示对多少个元素继续调整，length是在逐渐减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        // i * 2 + 1 => i 的左孩子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k+1 < length && arr[k] < arr[k+1]) { // 如果左子节点小于右子节点
                k++; // 指向右子节点
            }
            if (arr[k] > temp) { // 如果子节点大于父节点
                arr[i] = arr[k]; // 把较大的值赋值给当前节点
                i = k; // i指向k，继续循环比较
            } else {
                break;
            }
        }
        // 当for 循环结束后，以i节点为父节点的子树已经成为了大顶堆
        arr[i] = temp;
    }

}
