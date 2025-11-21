package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-19-14:53
 */
public class d1_53maxSubArray {
    public static void main(String[] args) {
        d1_53maxSubArray d153maxSubArray = new d1_53maxSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(d153maxSubArray.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int max =  nums[0];
        int currentNum = 0;
        for (int i=0;i<nums.length;i++){
            currentNum = Math.max(nums[i],currentNum+nums[i]);
            max = Math.max(max,currentNum);
        }
        return max;
    }

}
