package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-07-17-14:16
 */
public class a6_189rotate {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        rotate(nums, 5);
    }
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int len = nums.length;
        int[] temp = new int[k];
        System.arraycopy(nums, len - k, temp, 0, k);
        for (int i = 0; i < len - k; i++) {
            nums[len - i - 1] = nums[len - k - i - 1];
        }
        System.arraycopy(temp, 0, nums, 0, k);
        OutArrays.outArrays(nums);

    }
}
