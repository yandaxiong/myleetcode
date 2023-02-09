package com.xiong.top100;

import java.util.HashMap;

/**
 * @author xiong
 * @Description     给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @date 2023-02-08 4:58 下午
 */
public class longest_substring_without_repeating_characters_3 {

    public static void main(String[] args) {
        int len = lengthOfLongestSubstring("dsfadsfasdfxxddfnj");
        System.out.println(len);
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length == 0){
            return 0;
        }
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i=0;i<length;i++){
            if(charMap.containsKey(s.charAt(i))){
                left = Math.max(left,charMap.get(s.charAt(i))+1);
            }
            charMap.put(s.charAt(i),i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }

}
