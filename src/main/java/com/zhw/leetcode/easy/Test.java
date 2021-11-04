package com.zhw.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Test {
    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        // System.out.println(fibonacci(5));

        Fun f = (key) -> {
            System.out.println(key);
            return key + 1;
        };

        System.out.println(f.app(3));

    }

    /*static int fibonacci(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }

        return (key) -> {
            System.out.println(key);
            return fibonacci(i-2) + fibonacci(i-1);
        };

//        return cache.computeIfAbsent(i,(key)-> {
//            System.out.println(key);
//            return fibonacci(i-2) + fibonacci(i-1);
//        });
    }*/

    interface Fun {
        int app(int t);
    }
}
