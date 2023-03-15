package com.xiong.top100;

/**
 * @author xiong
 * @Description
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 */
public class a9_palindrome_number {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(0);
        System.out.println(palindrome);
    }

    public static  boolean isPalindrome(int x) {
//        String s = Integer.toString(x);
//        int length = s.length();
//        for (int i=0;i<length/2;i++){
//            if(s.charAt(i)!=s.charAt(length-i-1)){
//                return false;
//            }
//        }
//        return true;
        if(x == 0){
            return true;
        }
        if(x<0 || x%10 == 0 ){
            return false;
        }
        int reverseNum = 0;
        while (reverseNum<x){
            reverseNum = reverseNum*10 + x%10;
            x = x/10;
        }
        return reverseNum == x || reverseNum/10 == x;



    }
}
