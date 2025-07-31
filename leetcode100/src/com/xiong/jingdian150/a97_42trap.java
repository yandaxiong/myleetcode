package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-30-15:57
 */
public class a97_42trap {
    public static void main(String[] args) {
       int[] nums = {4,2,0,3,2,5};
       System.out.println(trap(nums));
    }
    public static int trap(int[] height) {
        int left = 0;
        int leftResult = 0;
        int right = 0;
        int rightResult = 0;
        int maxIndex = 0;
        int maxHeight = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < maxIndex; i++) {
            if(height[i] >= left) {
                left = height[i];
            }else {
                leftResult = leftResult + (left-height[i]);
            }
        }
        for (int i = height.length-1; i >maxIndex ; i--) {
            if(height[i] >= right) {
                right = height[i];
            }else {
                rightResult = rightResult + (right-height[i]);
            }
        }
        return leftResult+rightResult;
    }
}
