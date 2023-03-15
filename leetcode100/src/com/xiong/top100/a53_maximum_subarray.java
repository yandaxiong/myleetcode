package com.xiong.top100;

/**
 * @author xiong
 * @Description 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * @date 2023-03-06 6:22 下午
 */
public class a53_maximum_subarray {
    public static void main(String[] args) {
        a53_maximum_subarray a53 = new a53_maximum_subarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(a53.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentNum = 0;
        for (int num:nums){
            if(currentNum>0){
                currentNum = currentNum+num;
            }else {
                currentNum = num;
            }
            max = Math.max(currentNum, max);
        }
        return max;
    }
}
