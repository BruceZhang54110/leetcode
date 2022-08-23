package com.zhw.leetcode.erfenfa;

/**
 * 二分法查找
 */
public class SearchTargetNumber1 {

    public static void main(String[] args) {
        int[] nums = {-2,0,1,2,3,4,6,8,9};
        int num = getNum(nums, 0, nums.length - 1, 2);
        System.out.println(num);
    }


    public static int getNum(int[] nums, int low, int high, int target) {
        if (low <= high) {
            int mid = (high - low)/2 + low;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                return getNum(nums, mid + 1, high, target);
            }
            if (nums[mid] > target) {
                return getNum(nums, low, mid - 1, target);
            }
        }
        return -1;
    }


}
