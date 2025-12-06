package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-26-19:09
 */
public class j4_5longestPalindrome {
    public static void main(String[] args) {
        j4_5longestPalindrome j4_5longestPalindrome = new j4_5longestPalindrome();
        System.out.println(j4_5longestPalindrome.longestPalindrome("babad"));
//        System.out.println("abc".substring(0,1));

    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String result  = "";
        for (int i=1;i<s.length();i++){
            for (int j=0;j<=i-result.length();j++){
                String substring = s.substring(j, i + 1);
                if (huiwen(substring) &&  result.length() < substring.length()  ){
                    result = substring;
                }
            }
        }
        return result;
    }
    public boolean huiwen(String s){
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-i-1)) {
                return  false;
            }
        }
        return  true;
    }

}
