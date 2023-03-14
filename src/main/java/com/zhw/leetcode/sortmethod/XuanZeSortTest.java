package com.zhw.leetcode.sortmethod;

import java.util.Arrays;

/**
 * 选择排序
 */
public class XuanZeSortTest {
    public static void main(String[] args) {
        int[] array = new int[]{56,45,34,23,22,14,3,2,1};
        sortArray(array);
        System.out.println(Arrays.toString(array));
    }


    public static int[] sortArray(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    // 发现更小的交换下标
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                //交换minIndex和i 的元素
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }
}
