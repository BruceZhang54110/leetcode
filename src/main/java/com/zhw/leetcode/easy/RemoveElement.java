package com.zhw.leetcode.easy;

/**
 * 移除元素
 *给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElement {
    public static void main(String[] args) {
        int array[] = {3,2,2,3};
        method2(array, 3);
        for (int i : array) {
            System.out.print(i + ", ");
        }
    }

    /**
     * 方法一
     * 双指针，快慢指针
     * @param array
     * @param val
     * @return
     */
    public static int method1(int[] array, int val) {
        int length = array.length;
        int left = 0;
        for (int right = 0; right < length; right++) {
            if (array[right] != val) {
                array[left] = array[right];
                left++;
            }
        }
        return left;
    }

    /**
     * 方法二，双指针的优化版本
     * @param array
     * @param val
     * @return
     */
    public static int method2(int[] array, int val) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            if (array[left] == val) {
                array[left] = array[right - 1];
                right --;
            } else {
                left ++;
            }
        }
        return left;
    }

}
