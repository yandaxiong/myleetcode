package com.xiong.top100;

/**
 * @author xiong
 * @Description
 * @date 2023-02-06 5:21 下午
 */
public class two_sum_1 {
    public int[] twoSum(int[] nums, int target) {
        int x = nums.length;
        for(int i=0;i<x-1;i++){
            for (int j=i;j<x;j++){
                 int result = nums[i]+nums[j];
                 if(result == target){
                     int[] resultArray = {i,j};
                    return resultArray;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }

}


