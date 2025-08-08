package com.xiong.jingdian150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @author xiong
 * @create 2025-08-07-21:06
 */
public class e3_290wordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
    public static boolean wordPattern(String pattern, String s) {
        char[] sCharArray = pattern.toCharArray();
        String[] tCharArray = s.split(" ");
        if (tCharArray.length != sCharArray.length) {return false;}
        HashMap<Character, String> hashMap = new HashMap<>();
        HashSet<String> characters = new HashSet<>();
        for (int i = 0; i < sCharArray.length; i++) {
            if (!hashMap.containsKey(sCharArray[i])) {
                if(characters.contains(tCharArray[i])) return false;
                hashMap.put(sCharArray[i], tCharArray[i]);
                characters.add(tCharArray[i]);
            }else {
                if (!Objects.equals(hashMap.get(sCharArray[i]), tCharArray[i])) {return false;}
            }

        }
        return true;
    }
}
