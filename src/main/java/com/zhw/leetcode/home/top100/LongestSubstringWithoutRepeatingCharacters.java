package com.zhw.leetcode.home.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * class Solution {
 *     public int lengthOfLongestSubstring(String s) {
 *         Map<Character, Integer> map = new HashMap<>();
 *         int res = 0, left = 0, right = 0;
 *         while (right < s.length()) {
 *             char c = s.charAt(right);
 *             if (map.containsKey(c)) {
 *                 left = Math.max(left, map.get(c) + 1);
 *             }
 *             map.put(c, right++);
 *             res = Math.max(res, right - left);
 *         }
 *         return res;
 *     }
 * }
 *
 * 作者：maczhen
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/3-wu-zhong-fu-zi-fu-de-zui-chang-zi-chua-xjeu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        // paaseddvg
                System.out.println(lengthOfLongestSubstring("paaseddvg"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // 如果map中包含说明发生重复字符，left指针要右移重复字符的下一个索引
                left = Math.max(left, map.get(c));
            }
            map.put(c, right+1);
            right ++;
            res = Math.max(res, right - left);
            System.out.println("res:" +res);
        }
        return res;

    }
}
