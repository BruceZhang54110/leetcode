package com.zhw.leetcode.sortmethod;


import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：最好是 O(n)，最坏是 O(N²)，平均 O(N²)
 * 图解： bubble_sort-2.gif
 * @see <a href="https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html#冒泡排序-bubble-sort">参考</a>
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
        // 第一层循环用来控制，每轮对比完最大元素到了尾部后，缩短对比范围
        for (int i = 1; i < array.length; i++) {
            // 第二层循环结束后，i 的值+1 ，j 范围 - 1，缩短对比范围
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

    public static int[] sorta(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
