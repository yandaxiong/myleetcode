package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-30-17:27
 */
public class a991_58lengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World  "));
    }
    public static int lengthOfLastWord(String s) {
        char[] charArray = s.toCharArray();
        int result = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] != ' ') {
                result++;
            }else {
                if (result !=0) {
                    break;
                }
            }
        }
        return result;
    }
}
