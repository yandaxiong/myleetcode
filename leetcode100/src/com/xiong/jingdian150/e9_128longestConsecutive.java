package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.Arrays;

/**
 * @author xiong
 * @create 2025-08-11-20:30
 */
public class e9_128longestConsecutive {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
    public  static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        Arrays.sort(nums);
        int result = 1;
        int longest = 1;
        OutArrays.outArrays(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]+1) {
                longest++;
            }
            if (nums[i]>nums[i-1]+1) {
                result = Math.max(longest,result);
                longest = 1;
            }
        }
        result = Math.max(longest,result);
        return result;
    }
}
