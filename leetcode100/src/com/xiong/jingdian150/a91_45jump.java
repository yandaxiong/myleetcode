package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-07-17-20:48
 * 跳跃游戏 II
 */
public class a91_45jump {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int[] results = new int[nums.length];
        for (int i = 1; i < results.length; i++) {
            results[i] = Integer.MAX_VALUE;
        }
        results[0] = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <=nums[i] && i+j<nums.length ; j++){
                results[i+j] = Math.min(results[i+j],results[i]+1) ;
            }
        }
        OutArrays.outArrays(results);
        return results[nums.length-1];

    }
}
