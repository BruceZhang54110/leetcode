package com.zhw.leetcode.erfenfa;

/**
 * 二分法查找X的算术平方根
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(getNum(7));
    }


    public static int getNum(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0;
        int right = x;
        while (left <= right) {
            System.out.println("left:"+left+", right:" + right);
            int mid = (right - left)/2 + left;
            if (mid == x / mid) {
                return mid;
            }
            if (mid < x / mid) {
                left = mid + 1;
                continue;
            }
            if (mid > x / mid) {
                right = mid - 1;
                continue;
            }
        }

        return right;
    }


}
