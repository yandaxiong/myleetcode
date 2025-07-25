package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-07-24-20:43
 *
 */
public class a94_238productExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        OutArrays.outArrays(productExceptSelf(nums));

    }
    public static int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        int[] result = new int[nums.length];
        l[0] = 1;
        r[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = l[i-1] * nums[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            r[i] = r[i+1] * nums[i+1];
        }
        result[0] = r[0];
        result[nums.length-1] = l[nums.length-1];
        for (int i = 1; i < nums.length-1; i++) {
            result[i] = l[i] * r[i];
        }
        return result;
    }
}
