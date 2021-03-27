package com.zhw.leetcode.easy.number;

/**
 * 罗马数字转整数
 * 按照题目的描述，可以总结如下规则：
 *
 * 罗马数字由 I,V,X,L,C,D,M 构成；
 * 当小值在大值的左边，则减小值，如 IV=5-1=4；
 * 当小值在大值的右边，则加小值，如 VI=5+1=6；
 * 由上可知，右值永远为正，因此最后一位必然为正。
 *
 * 作者：donespeak
 * 链接：https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 一言蔽之，把一个小值放在大值的左边，就是做减法，否则为加法。
 */
public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.trans("XXVII"));

        System.out.println();
    }

    public int trans(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;

            } else {
                sum+= preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
