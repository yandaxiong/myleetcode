package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-11-19-15:13
 */
public class d2_918maxSubarraySumCircular {
    public static void main(String[] args) {
        d2_918maxSubarraySumCircular c2918maxSubarraySumCircular = new d2_918maxSubarraySumCircular();
        int[] nums = new int[]{5,-3,5};
        System.out.println(c2918maxSubarraySumCircular.maxSubarraySumCircular(nums));
    }
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int currentNum = 0;
        for (int i=0;i<nums.length;i++){
            currentNum = Math.max(nums[i],currentNum+nums[i]);
            max = Math.max(max,currentNum);
        }
        int jSum = 0;
        int[] iMax = new int[nums.length+1];
        iMax[0] = 0;
        int iSum = 0;
        for (int i=0;i<nums.length;i++){
            iSum = iSum+nums[i];
            iMax[i+1] = Math.max(iSum,iMax[i]);
        }

        for (int j=nums.length-1;j>0;j--){
            jSum = jSum+nums[j];
            max = Math.max(max,jSum+iMax[j-1]);
        }
        return max;
    }
}
