package com.zhw.leetcode.erfenfa;

public class SearchTarget {

    public static void main(String[] args) {
        // int nums[] = new int[]{-2, 4, 5, 6, 9, 13};
        int nums[] = new int[]{1,3,5};
        int searchInsert = searchInsert(nums, 2);
        System.out.println(searchInsert);
    }

    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left)/2 + left;
            System.out.println("mid+:" + mid);
            if (nums[mid] < target) {
                left = mid + 1;
                System.out.println("left+1= :" + left);
            } else {
                right = mid - 1;
                System.out.println("right-1:" + right);
            }
        }
        return left;
    }
}
