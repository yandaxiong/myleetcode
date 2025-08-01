package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-31-10:39
 */
public class b2_392isSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) { return true; }
        char[] sArray = s.toCharArray();
        char[] tArray2 = t.toCharArray();
        int i = 0, j = 0;
        while (i < sArray.length && j < tArray2.length) {
            if (sArray[i] == tArray2[j]) {
                if (i == sArray.length-1) {
                    return true;
                }
                i++;
                j++;
            }else {
                j++;
            }
        }
        return false;

    }
}
