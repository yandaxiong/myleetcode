package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-30-17:44
 */
public class a993_151reverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = s1.length-1; i >=0; i--) {
            if (!s1[i].equals("")) {
                sb.append(s1[i] + " ");
            }
        }
        return sb.toString().trim();
    }
}
