package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-07-16-17:40
 */
public class a4_80removeDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        removeDuplicates(nums);
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length<3) return nums.length;
        int j = 2;
        int num = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j-1] || nums[i] != nums[j-2]   ) {
                nums[j] = nums[i];
                j++;
                num++;
            }
        }
        OutArrays.outArrays(nums);
        System.out.println(num);
        return num;
    }
}
