package com.zhw.leetcode.heaptest;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度：O(nlogn)
 */
public class HeapSortTest {
    public static void main(String[] args) {
        int arr[] = {6,9,7,8,5,0,1,2,4,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 调整
     * @param arr 数组列表
     * @param low 堆的根节点位置
     * @param high 堆的最后一个元素的位置
     */
    public static void sift(int[] arr, int low, int high) {
        int i = low;
        // j开始是左孩子
        int j = 2 * i +1;
        int tmp = arr[low];

        // 只要j节点有数
        while (j <= high) {
            // 如果有右孩子，且右孩子比较大
            if (j+1 <= high && arr[j+1] > arr[j]) {
                j = j + 1; // j 指向右孩子
            }
            if (arr[j] > tmp) {
                arr[i] = arr[j];
                i = j; // 往下看一层
                j = i * 2 + 1;
            } else {
                // tmp 更大，把tmp 放到i的位置上
                // arr[i] = tmp; // 把tmp放到某个大值
                break;
            }
        }
        arr[i] = tmp; // 把tmp 放到当前叶子结点上，其实 i 属于某个节点的父节点
    }
    public static void sort(int[] arr) {
        int length = arr.length;
        // 建堆： 农村包围城市
        // 找到最后一个非叶子节点，最后一个节点下标为length-1，设 孩子节点为i,父亲节点为就j=(i-1)/2
        // 建堆任务 start
        for (int i = (length - 2) / 2; i >=0 ; i--) {
            // i 表示建堆时候，调整的部分的根的下标
            sift(arr, i, length-1);
        }
        // 建堆任务 end

        // 挨个将根节点拿下来,倒序for循环
        // i 表示最后一个节点，和 根节点交换，这样根节点成了 arr[i],就变成【节点的左右子树都是堆，但自身不是堆】
        for (int i = length - 1; i>=0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            // 进行一次向下调整
            sift(arr, 0, i-1);
        }
    }
}
