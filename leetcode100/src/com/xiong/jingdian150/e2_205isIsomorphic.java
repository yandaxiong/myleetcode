package com.xiong.jingdian150;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author xiong
 * @create 2025-08-07-20:52
 */
public class e2_205isIsomorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }
    public static boolean isIsomorphic(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        HashMap<Character, Character> hashMap = new HashMap<>();
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < sCharArray.length; i++) {
            if (!hashMap.containsKey(sCharArray[i])) {
                if(characters.contains(tCharArray[i])) return false;
                hashMap.put(sCharArray[i], tCharArray[i]);
                characters.add(tCharArray[i]);
            }else {
                if (hashMap.get(sCharArray[i]) != tCharArray[i]) {return false;}
            }

        }
        return true;
    }
}
