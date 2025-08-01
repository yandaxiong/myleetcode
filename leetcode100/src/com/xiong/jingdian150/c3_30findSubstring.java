package com.xiong.jingdian150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiong
 * @create 2025-07-31-20:58
 */
public class c3_30findSubstring {
    public static void main(String[] args) {
        String[] word = {"foo","bar"};
        System.out.println(findSubstring("barfoothefoobarman", word));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> reaultList = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],map.getOrDefault(words[i],0) + 1);
        }
        int len = words.length;
        int wordLen = words[0].length();
        for (int i = 0; i <len-wordLen*len+1; i++) {

        }

        return reaultList;

    }
}
