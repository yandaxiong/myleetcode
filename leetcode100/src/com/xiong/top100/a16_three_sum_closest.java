package com.xiong.top100;

import java.util.Arrays;

/**
 * @author xiong
 * @Description 最接近的三数之和
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 * @date 2023-02-24 10:46 上午
 */
public class a16_three_sum_closest {
    public static void main(String[] args) {
        int [] a = {0,1,1,1};
        System.out.println(threeSumClosest(a,-100));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int differ = Integer.MAX_VALUE;
        for (int first=0;first<nums.length-2;first++){
            if(first>1 && nums[first]==nums[first-1]){
                continue;
            }
            int second = first+1;
            int three = nums.length-1;
            while (second<three){
                int differAbs = Math.abs(target - nums[first] - nums[second] - nums[three]);
                if(differAbs<differ){
                    result = nums[first] + nums[second] + nums[three];
                    differ = differAbs;
                }
                if(nums[first]+nums[second]+nums[three]==target){
                    return result;
                }else if (nums[first]+nums[second]+nums[three]>target){
                    three--;
                }else {
                    second++;
                }
            }

        }
        return result;

    }
}
