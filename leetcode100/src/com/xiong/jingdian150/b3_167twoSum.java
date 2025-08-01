package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-07-31-10:54
 */
public class b3_167twoSum {
    public static void main(String[] args) {
        int[] nums = {2,3,4};
        int target = 6;
        OutArrays.outArrays(twoSum(nums, target));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            }
            if (sum < target) {
                left++;
            }
            if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
