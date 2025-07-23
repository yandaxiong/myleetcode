package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-16-17:54
 * 多数元素
 */
public class a5_169majorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2,2,1};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
         int result = nums[0];
         int count = 1;
         for (int i = 1; i < nums.length; i++) {
             if (nums[i] == result) {
                 count++;
             }else {
                 count--;
                 if (count == 0) {
                     result = nums[i+1];
                 }
             }
         }
         return result;


//        if(nums.length<=2) return nums[0];
//        for (int i = 0; i < nums.length; i=i+2) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] != nums[j]) {
//                    int temp = nums[i+1];
//                    nums[i+1] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
//        return nums[nums.length-1];
    }
}
