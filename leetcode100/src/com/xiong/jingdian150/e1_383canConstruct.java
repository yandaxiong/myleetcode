package com.xiong.jingdian150;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xiong
 * @create 2025-08-07-20:40
 */
public class e1_383canConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa","ab"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] rCharArray = ransomNote.toCharArray();
        char[] mCharArray = magazine.toCharArray();
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (char c : mCharArray) {
            characterIntegerHashMap.put(Character.valueOf(c), characterIntegerHashMap.getOrDefault(c, 0) + 1);
        }
        for (char c : rCharArray) {
            if (!characterIntegerHashMap.containsKey(c)) {return false;}
            characterIntegerHashMap.replace(c, characterIntegerHashMap.getOrDefault(c, 0) - 1);
            if (characterIntegerHashMap.get(c) == -1) {return false;}
        }
        return true;
    }
}
