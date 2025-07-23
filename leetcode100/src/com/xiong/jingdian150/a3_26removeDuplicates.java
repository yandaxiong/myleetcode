package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-07-16-11:31
 * 26. 删除有序数组中的重复项
 */
public class a3_26removeDuplicates {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums1);
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int num=1;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[num-1]){
                nums[num++]=nums[j];
            }
        }
        OutArrays.outArrays(nums);
        System.out.println(num);
        return num;
    }
}
