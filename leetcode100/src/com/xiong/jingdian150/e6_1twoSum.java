package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.Arrays;

/**
 * @author xiong
 * @create 2025-08-08-11:13
 */
public class e6_1twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        OutArrays.outArrays(twoSum(nums, target));
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
