package com.zhw.leetcode.jd;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 说明：
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 1：
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 */
public class Code151 {
    public static void main(String[] args) {
        String s = "the sky   is blue";
        StringBuilder sb = trimSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseWord(sb);
        System.out.println(sb);
    }
    /**
     * 使用java api 翻转
     * @param s
     * @return
     */
    public static String reverseWords1(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
    /**
     * 反转字符串
     * @param sb
     * @param left
     * @param right
     */
    private static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    private static void reverseWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0;
        int end = 0;
        while (start < n) {
            // 寻找到单词末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 反转单词
            reverse(sb, start, end - 1);
            // 更新start 寻找下一个单词
            start = end + 1;
            ++end;
        }
    }

    private static StringBuilder trimSpaces(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }
        // 将字符串之间多余的空白字符去掉
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }
}
