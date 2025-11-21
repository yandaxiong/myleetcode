package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-11-19-20:09
 */
public class e5_34searchRange {
    public static void main(String[] args) {
        e5_34searchRange e534searchRange = new e5_34searchRange();
        int[] nums = new int[]{1,2,3,3,3,3,4,5,9};
        int[] ints = e534searchRange.searchRange(nums, 3);
        OutArrays.outArrays(ints);
    }
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int med=-1;
        while (left<=right){
            int medium = (left+right)/2;
            if (target == nums[medium]){
                med = medium;
                break;
            }else if(target<nums[medium]){
                right = medium-1;
            }else {
                left = medium+1;
            }
        }
        if (med==-1){
            return new int[]{-1,-1};
        }
        int leftMed = med;
        int rightMed = med;
        int leftresult = med;
        int rightresult = med;

        if(nums[left]==target){
            leftresult = left;
        }else {
            while (left <= leftMed) {
                int medium = (left + leftMed) / 2;
                if (nums[medium] == target) {
                    if (nums[medium - 1] < target) {
                        leftresult = medium;
                        break;
                    } else {
                        leftMed = medium - 1;
                    }
                } else {
                    left = medium + 1;
                }
            }
        }

        if(nums[right]==target){
            rightresult = right;
        }else{
            while(right>=rightMed){
                int medium = (right+rightMed)/2;
                if(nums[medium]==target){
                    if(nums[medium+1]>target){
                        rightresult = medium;
                        break;
                    }else {
                        rightMed = medium+1;
                    }
                }else {
                    right = medium-1;
                }
            }
        }
        return new int[]{leftresult,rightresult};
    }
}
