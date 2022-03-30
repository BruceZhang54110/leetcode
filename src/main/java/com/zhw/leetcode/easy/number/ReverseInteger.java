package com.zhw.leetcode.easy.number;

/**
 * 整数反转
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-123));
    }

    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            // 每次是末尾数字
            int temp = x%10;
            // 判断是否大于最大32位数
            if (res > 214748364 || (res == 214748364 &&temp > 7)) {
                return 0;
            }
            if (res < -214748364 ||(res == -214748364 && temp < -8 )) {
                return 0;
            }
            res = res * 10 +temp;
            x = x/10;

        }
        return res;
    }
}
