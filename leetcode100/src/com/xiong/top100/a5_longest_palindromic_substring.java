package com.xiong.top100;

import javax.lang.model.element.VariableElement;

/**
 * @author xiong
 * @Description
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * @date 2023-02-17 4:18 下午
 */
public class a5_longest_palindromic_substring {
    public static void main(String[] args) {
        String s = "bbbbbbbbb";
        String s1 = longestPalindrome(s);
        System.out.println(s1);

    }
    public static  String longestPalindrome(String s) {

        int maxLeft = 0;
        int maxLRight = 0;
        int maxLen = 1;
        int strLen = s.length();
        boolean flag = true;
        for(int i=0;i<strLen;i++){
            int left = i-1;
            int right = i+1;
            while (i>0 && left>=0 && flag ){
                if(s.charAt(i)==s.charAt(left)){
                    left --;
                }else {
                    flag = false;
                }
            }
            flag = true;
            while (right<strLen && flag ){
                if(s.charAt(i)==s.charAt(right)){
                    right ++;
                }else {
                    flag = false;
                }
            }
            while (left>=0 && right<strLen && s.charAt(left)==s.charAt(right)){
                left --;
                right ++;
            }
            if(maxLen<(right-left+1)){
                maxLeft = left+1;
                maxLRight = right;
                maxLen = right-left+1;
            }
        }
        return s.substring(maxLeft,maxLRight);
    }
    /**
     * 最差的方法
     * @param s
     * @return
     */
    public static  String longestPalindrome1(String s) {
        int length = s.length();
        if(s.length()<=1){
            return s;
        }
        String resultStr = "";
        for(int i = 0 ; i< length; i++){
            for (int j = i+1;j<=length;j++){
                String compareStr1 = s.substring(i,j);
                String compareStr2 = new StringBuffer(compareStr1).reverse().toString();
                if(compareStr1.equals(compareStr2)){
                    if(compareStr1.length()>resultStr.length()){
                        resultStr = compareStr1;
                    }
                }
            }
        }
        return  resultStr;
    }
}
