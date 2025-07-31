package com.xiong.jingdian150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiong
 * @create 2025-07-30-17:11
 */
public class a98_13romanToInt {
    public static void main(String[] args) {

        System.out.println(romanToInt("III"));
    }
    public static int romanToInt(String s) {
        int ans=0;
        char c[]=s.toCharArray();
        int n=c.length;
        Map<Character, Integer> map=new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for(char i:c) {
            ans+=map.get(i);
        }
        if(s.contains("IV"))ans-=2;
        if(s.contains("IX"))ans-=2;
        if(s.contains("XL"))ans-=20;
        if(s.contains("XC"))ans-=20;
        if(s.contains("CD"))ans-=200;
        if(s.contains("CM"))ans-=200;
        return ans;
    }
}
