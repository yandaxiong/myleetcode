package com.xiong.jingdian150;

import java.util.Arrays;

/**
 * @author xiong
 * @create 2025-08-07-21:10
 */
public class e4_242isAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        if(sCharArray.length != tCharArray.length) return false;
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);

    }
}
