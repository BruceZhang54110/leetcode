package com.zhw.leetcode.heaptest;

import java.util.Arrays;

/**
 * 堆排序-小根堆 堆排序，解决top k问题，求第k个大的元素数组
 * 时间复杂度O(nlogn)
 */
public class topK {


    public static void main(String[] args) {
        int arr[] = {6,9,7,8,5,0,1,67,4,3};
        long start = System.currentTimeMillis();
        int[] topk = topk(arr, 5);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        System.out.println(Arrays.toString(topk));
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
            if ( (j + 1) <= high && arr[j] > arr[j + 1]) {
                j = j + 1; // 如果右孩子比左孩子大，j指向右孩子
            }
            if (arr[j] < tmp) {
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

    public static int[] topk(int[] arr, int k) {
        int heap[] = Arrays.copyOf(arr, k);
        System.out.println("begin:" + Arrays.toString(heap));
        // 1. 取前k个建小根堆
        for (int i = (k-2)/2; i >= 0; i--) {
            sift(i, k - 1, heap);
        }
        System.out.println("前k个建堆: " + Arrays.toString(heap));
        // 2. 从第k+1 个元素开始遍历
        for (int i = k; i < arr.length; i++) {
            System.out.print("^:");
            System.out.println(arr[i] + "");
            if (arr[i] > heap[0]) {
                System.out.println("arr[i]:" + arr[i] + ", heap[0]:" + heap[0]);
                // 说明此时堆顶不是前k大的数，就吧heap[0]替换为arr[i],然后做一次调整
                heap[0] = arr[i];
                sift(0, k - 1, heap);
                System.out.println("调整：" + Arrays.toString(heap));
            }
        }
        System.out.println("从第k+1 个元素开始遍历: " + Arrays.toString(heap));
        // 3. 逐个出数
        for (int i = k - 1; i >= 0; i--) {
            System.out.println("第"+i+"次出数： " + Arrays.toString(heap));
            // i 指向当前堆的最后一个元素
            // 堆顶元素和最后一个交换
            int tmp = heap[i];
            heap[i] = heap[0];
            heap[0] = tmp;
            // 出一个后，需要向下调整（调整为小根堆），让其满足堆的性质
            sift(0, i - 1, heap);
        }
        return heap;
    }

}
