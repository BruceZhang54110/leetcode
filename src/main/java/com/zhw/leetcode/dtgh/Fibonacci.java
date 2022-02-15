package com.zhw.leetcode.dtgh;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(f(10));
    }

    public static int f(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n;i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }
}
