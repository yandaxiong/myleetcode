package com.xiong.jingdian150_3;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-11-26-14:54
 */
public class h5_300lengthOfLIS {
    public static void main(String[] args) {
        System.out.println(new h5_300lengthOfLIS().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));

    }
    public int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        int maxResult = 1;
        for (int i=1;i<nums.length;i++){
            int max = 1;
            for (int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    max = Math.max(max, result[j]+1);
                }
            }
            result[i] = max;
            maxResult = Math.max(maxResult, result[i]);
        }
        return maxResult;
    }

}
