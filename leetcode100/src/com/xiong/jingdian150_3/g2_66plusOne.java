package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-25-15:31
 */
public class g2_66plusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        g2_66plusOne g2_66plusOne = new g2_66plusOne();
        int[] ints = g2_66plusOne.plusOne(digits);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            int digit = digits[i];
            if(digit!=9){
                digits[i] = digit+1;
                return  digits;
            }else {
                digits[i] = 0;
            }
        }
        int[] ints = new int[digits.length + 1];
        ints[0]=1;
        return  ints;
    }
}
