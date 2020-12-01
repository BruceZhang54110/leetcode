package com.zhw.leetcode.easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("a", new ArrayList<>());
        map.get("a").add("1111");

        List<String> a = map.get("a");
        a.add("2222");

        List<String> a1 = map.get("a");
        for (String s : a1) {
            System.out.println(s);
        }
    }
}
