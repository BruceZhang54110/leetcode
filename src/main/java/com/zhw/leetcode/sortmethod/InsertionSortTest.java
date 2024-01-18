package com.zhw.leetcode.sortmethod;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 插入排序是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用 in-place 排序（即只需用到 O(1) 的额外空间的排序），
 * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 * 插入排序的代码实现虽然没有冒泡排序和选择排序那么简单粗暴，但它的原理应该是最容易理解的了，
 * 因为只要打过扑克牌的人都应该能够秒懂。插入排序是一种最简单直观的排序算法，它的工作原理是通过构建有序序列，
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序和冒泡排序一样，也有一种优化算法，叫做拆半插入。
 * ---------------------------
 * # 算法步骤
 * 1.从第一个元素开始，该元素可以认为已经被排序；
 * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置；将新元素插入到该位置后；
 * 重复步骤 2~5。#
 * ------
 * 著作权归JavaGuide(javaguide.cn)所有
 * 基于MIT协议
 * 原文链接：https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html
 *
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
