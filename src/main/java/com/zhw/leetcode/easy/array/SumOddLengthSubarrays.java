package com.zhw.leetcode.easy.array;

public class SumOddLengthSubarrays {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,5,3};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
       /* // 暴力破解 时间复杂度是 O(n^3)
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; i+j-1 < arr.length; j+=2) {
                for (int k = i; k < i+j; k++) {
                    sum += arr[k];
                }
            }

        }*/

        int sum = 0;
        // 前缀和
        int[] prefixArr = new int[arr.length];
        for (int i = 0; i < prefixArr.length; i++) {
          if (i == 0) {
              prefixArr[i] = arr[i];
          } else {
              prefixArr[i] += prefixArr[i-1] + arr[i];
          }
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j+=2) {
                if (i == 0) {
                    System.out.println(prefixArr[j]);
                    sum += prefixArr[j];
                } else {
                    System.out.println("==================");
                    System.out.println(j);
                    System.out.println(i);
                    System.out.println("prefixArr[j]: " + prefixArr[j] + ",prefixArr[i-1] : " + prefixArr[i-1] +", : " + (prefixArr[j]-prefixArr[i-1]));

                    sum += prefixArr[j]-prefixArr[i-1];
                }
            }
        }
        return sum;

    }
}
