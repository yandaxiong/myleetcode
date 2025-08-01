package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.Arrays;

/**
 * @author xiong
 * @create 2025-07-31-17:26
 */
public class c1_209minSubArrayLen {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(minSubArrayLen(11, nums));

    }
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        int minCount = Integer.MAX_VALUE;
        while (start < nums.length) {
           end = start;
           while (sum < target) {
               if (end >= nums.length) {
                   start = end;
                   break;
               }
               sum += nums[end];
               end++;
           }
           if (sum >= target) {
               minCount = Math.min(minCount, end - start);
               sum=0;
               start = start+1;
           }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;

    }
}
