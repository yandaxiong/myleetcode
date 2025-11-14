package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-11-12-17:37
 */
public class g6_201rangeBitwiseAnd {
    public static void main(String[] args) {
        g6_201rangeBitwiseAnd g620rangeBitwiseAnd = new g6_201rangeBitwiseAnd();
        System.out.println(g620rangeBitwiseAnd.rangeBitwiseAnd(1, 2147483647));
    }
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0 ;
        while (left < right){
            left = left >> 1;
            right = right >> 1;
            shift ++;
        }
        return  right << shift;
    }


}
