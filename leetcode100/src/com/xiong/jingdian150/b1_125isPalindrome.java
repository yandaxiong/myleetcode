package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-31-10:24
 */
public class b1_125isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Pan11ama"));
    }
    public static boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        lowerCase = lowerCase.replaceAll("[^a-zA-Z0-9]", "");
        char[] charArray = lowerCase.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int j = charArray.length - i - 1;
            if (i>=j) {
                break;
            }
            if (charArray[i] != charArray[j]) {
                return false;
            }
        }
        return true;
    }
}
