package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-07-16-11:12
 * 26. 删除有序数组中的重复项
 */
public class a2_27removeElement {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0,1,2,2,3,0,4,2};
        removeElement(nums1, 2);
    }
    public static  int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        System.out.println(left);
        OutArrays.outArrays(nums);
        return left;

    }
}
