package com.zhw.leetcode.interview150;

public class Code26a {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
    }


    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while(fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow+1;
    }
}
