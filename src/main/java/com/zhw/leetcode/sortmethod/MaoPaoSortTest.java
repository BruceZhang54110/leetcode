package com.zhw.leetcode.sortmethod;


import java.util.Arrays;

/**
 * 冒泡排序
 */
public class MaoPaoSortTest {
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
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                // 进行比较f
                if (array[j]> array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
