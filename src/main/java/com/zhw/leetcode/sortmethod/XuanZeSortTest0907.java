package com.zhw.leetcode.sortmethod;

import java.util.Arrays;

public class XuanZeSortTest0907 {
    public static void main(String[] args) {
        int[] ints = {12, 4, 7, 3, 2, 78, 56};
        sortArray(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}
