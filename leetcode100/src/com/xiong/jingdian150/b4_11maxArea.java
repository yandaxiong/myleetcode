package com.xiong.jingdian150;

import java.util.Map;

/**
 * @author xiong
 * @create 2025-07-31-11:21
 */
public class b4_11maxArea {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));

    }
    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max,Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

}
