package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-30-17:31
 */
public class a992_14longestCommonPrefix {
    public static void main(String[] args) {
        String[]  str = {"","b"};
        System.out.println(longestCommonPrefix(str));
    }
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            char[] prefixArray = prefix.toCharArray();
            char[] tmp = strs[i].toCharArray();
            prefix="";
            for (int j = 0; j < tmp.length && j <prefixArray.length; j++) {
                if(tmp[j] == prefixArray[j]){
                    prefix = prefix+tmp[j];
                }else {
                    break;
                }
            }
            if(prefix.isEmpty()) break;
        }
        return prefix;
    }
}
