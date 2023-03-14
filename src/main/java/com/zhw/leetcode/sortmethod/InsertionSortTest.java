package com.zhw.leetcode.sortmethod;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度 O(n²)
 * 空间复杂度O(1)
 */
public class InsertionSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 6, 9, 10, 4, 2};
        sortArray(arr);
        Arrays.stream(arr).forEach(v -> System.out.println(v));
    }

    /**
     * 插入排序逻辑
     * @param array
     * @return
     */
    public static int[] sortArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int preIndex =i-1;
            int curr = array[i];
            while (preIndex >=0 && curr < array[preIndex]) {
                array[preIndex+1] = array[preIndex];
                preIndex-=1;
            }
            array[preIndex+1] = curr;
        }
        return array;
    }
}
