package com.xiong.top100;

import java.util.Arrays;

/**
 * @author xiong
 * @Description 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标
 * @date 2023-03-06 8:30 下午
 */
public class a55_jump_game {
    public static void main(String[] args) {
        a55_jump_game a55JumpGame = new a55_jump_game();
        int[] nums = {2,3,1,1,4};
        System.out.println(a55JumpGame.canJump2(nums));
    }
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] resultFlag = new boolean[len];
        resultFlag[len-1] = true;

        for (int i=nums.length-2;i>=0;i--){
            int OneNum = nums[i];
            for (int j=1;j<=OneNum;j++){
                if(i+j<=len-1 && resultFlag[i + j]){
                    resultFlag[i]=true;
                    break;
                }
            }
            System.out.println(Arrays.toString(resultFlag));
        }
        return  resultFlag[0];
    }
    public boolean canJump2(int[] nums) {
        int len = nums.length-1;
        int maxJump = 0;
        for (int i=0;i<=len;i++){
            if(maxJump<i){
                return false;
            }
            if(maxJump>=len){
                return true;
            }
            maxJump = Math.max(nums[i]+i,maxJump);
        }
        return false;
    }
}
