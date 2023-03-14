package com.zhw.leetcode.sortmethod;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSortTest {
    public static void main(String[] args) {
        int[] array = new int[]{56,45,34,23,22,14,3,2,1};
        sortArray(array);
        Arrays.stream(array).forEach(v -> System.out.println(v));
    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] sortArray(int[] array) {
        int n = array.length;
        int gap = n/2;
        while(gap > 0) {
            for (int i = gap; i < n; i++) {

            }
        }
        return array;
    }
}
