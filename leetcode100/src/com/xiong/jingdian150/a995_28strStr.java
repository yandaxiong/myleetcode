package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-30-20:33
 */
public class a995_28strStr {
    public static void main(String[] args) {
        System.out.println(strStr("aaa", "aaaa"));
    }
    public static int strStr(String haystack, String needle) {
        char[] charArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        for1:
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            for (int j = 0; j < needleCharArray.length; j++) {
                if (needleCharArray[j] != charArray[i+j]) {
                    continue for1;
                }
            }
            return  i;
        }
        return -1;
    }
}
