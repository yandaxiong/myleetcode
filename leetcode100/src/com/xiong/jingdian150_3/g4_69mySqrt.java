package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-25-15:53
 */
public class g4_69mySqrt {
    public static void main(String[] args) {
        g4_69mySqrt g4_69mySqrt = new g4_69mySqrt();
        System.out.println(g4_69mySqrt.mySqrt(1));
    }
    public int mySqrt(int x) {
        int left=0;
        int right=x;
        int ans =  -1;
        while (left<=right){
            int middle = left+(right-left)/2;
            if((long)middle*middle<=x){
                ans = middle;
                left = middle+1;

            }else {
                right = middle-1;
            }
        }
        return ans;
    }
}
