package com.xiong.top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiong
 * @Description 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @date 2023-03-03 11:00 上午
 */
public class a42_trapping_rain_water {
    public static void main(String[] args) {
        a42_trapping_rain_water a42 = new a42_trapping_rain_water();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(a42.trap2(height));
//        输出：6
    }
//    动态规划
    public int trap(int[] height) {
        int length = height.length;
        int[] leftHeight =new  int[length];
        int[] rightHeight =new  int[length];
        int leftMax = 0;
        int rightMax = 0;
        for (int i=0;i<length;i++){
            leftMax = Math.max(leftMax, height[i]);
            leftHeight[i] = leftMax;
        }
        for (int i=length-1;i>=0;i--){
            rightMax = Math.max(rightMax, height[i]);
            rightHeight[i] = rightMax;
        }
        int ans = 0;
        for (int i=0;i<length-1;i++){
            ans = ans + Math.min(rightHeight[i],leftHeight[i])-height[i];
        }
        return ans;
    }

//栈
    public int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0;i<height.length;i++){
            while (!stack.isEmpty() && height[stack.peek()]<height[i]){
                Integer pop = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                ans = ans + (Math.min(height[i],height[stack.peek()])-height[pop] )* (i-stack.peek()-1)   ;
            }
            stack.push(i);
        }

        return ans;
    }
}
