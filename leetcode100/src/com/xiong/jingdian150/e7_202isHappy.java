package com.xiong.jingdian150;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author xiong
 * @create 2025-08-08-11:17
 */
public class e7_202isHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> integers = new HashSet<>();
        if(n == 1) return true;
        while(!integers.contains(n)) {
            integers.add(n);
            int temp = 0;
            while(n > 0) {
                temp =  temp  + (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
            if(n == 1) return true;
        }
        return false;

    }
}
