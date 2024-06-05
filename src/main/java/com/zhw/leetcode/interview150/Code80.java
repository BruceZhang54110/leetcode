package com.zhw.leetcode.interview150;

/**
 * 80. 删除排序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Code80 {
    public static void main(String[] args) {

        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }
        int slow = 0;
        int fast = 2;
        while (fast < length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 2] = nums[fast];
                slow++;
            }
            fast+=1;
        }
        return slow + 2;
    }
}
