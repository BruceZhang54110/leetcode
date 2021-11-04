package com.zhw.leetcode.home.top100;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        // paaseddvg
        System.out.println(lengthOfLongestSubstring("paasad"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>(0);
        while(right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c));
            }
            map.put(c, right + 1);
            right ++;
            res = Math.max(res, right - left);
        }
        return res;

    }
}
