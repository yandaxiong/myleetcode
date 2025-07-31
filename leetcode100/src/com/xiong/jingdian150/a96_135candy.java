package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-30-14:32
 */
public class a96_135candy {

    public static void main(String[] args) {
        int[] nums = {1,0,2};
        System.out.println(candy(nums));
    }
    public static int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = 1;
        right[ratings.length-1] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }else {
                left[i] = 1;
            }
        }
        int res = Math.max(left[ratings.length-1], 1);
        for(int i = ratings.length-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }else {
                right[i] = 1;
            }
            res = res + Math.max(right[i], left[i]);
        }
        return res;


    }

}
