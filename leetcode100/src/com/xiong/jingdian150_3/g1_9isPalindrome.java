package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-24-17:49
 */
public class g1_9isPalindrome {
    public static void main(String[] args) {
        g1_9isPalindrome g1_9isPalindrome = new g1_9isPalindrome();
        int x = 121;
        System.out.println(g1_9isPalindrome.isPalindrome(x));
    }
    public boolean isPalindrome(int x) {
        char[] ints = (x + "").toCharArray();
        for (int i=0,j=ints.length-1;i<j;i++,j--){
            if(ints[i]!=ints[j]){
                return false;
            }
        }
        return true;
    }
}
