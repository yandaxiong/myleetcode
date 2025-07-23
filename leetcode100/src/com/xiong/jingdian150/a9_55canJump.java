package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-17-20:34
 * 跳跃游戏
 */
public class a9_55canJump {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int max = 1;
        int length = nums.length;
        for (int i = 0; i < max && i<length; i++) {
            max = Math.max(max, i+1+nums[i]);
        }
        return max >= length;
    }

}
