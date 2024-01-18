package com.zhw.leetcode.sortmethod;

import java.util.Arrays;

/**
 * 选择排序
 * 选择排序是一种简单直观的排序算法，
 * 无论什么数据进去都是 O(n²) 的时间复杂度。所以用到它的时候，数据规模越小越好。
 * 唯一的好处可能就是不占用额外的内存空间了吧。它的工作原理：
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * -------------------------
 * # 算法步骤：
 * 首先在未排序序列中找到最小（大）元素，
 * 存放到排序序列的起始位置再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 重复第 2 步，直到所有元素均排序完毕。#
 * ---------------------------
 * 著作权归JavaGuide(javaguide.cn)所有
 * 基于MIT协议
 * 原文链接：https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html
 * 时间复杂度：O(n²)
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
