package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-20-16:22
 */
public class e6_153findMin {
    public static void main(String[] args) {
        e6_153findMin e6153findMin = new e6_153findMin();
        System.out.println(e6153findMin.findMin(new int[]{4,5,1,2,3}));
    }
    public int findMin(int[] nums) {
        if (nums.length==1) return nums[0];
        int left = 0;
        int right = nums.length-1;
        int min = nums[0];
        while (left<=right){
            int medium = (left+right)/2;
            if(isOrder(nums,left,medium) && isOrder(nums,medium+1,right)){
                return  Math.min(nums[left],nums[medium+1]) ;
            }
            if (isOrder(nums,left,medium)){
                left = medium+1;
            }else {
                right = medium;
            }
        }
        return min;
    }

    public boolean isOrder(int[] nums,int left,int right){
        if(nums[left]<=nums[right]){
            return true;
        }else {
            return false;
        }

    }



}
