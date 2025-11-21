package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-19-16:45
 */
public class e1_35searchInsert {
    public static void main(String[] args) {
        e1_35searchInsert e135searchInsert = new e1_35searchInsert();
        int[] nums = new int[]{1,3,5,6};
        System.out.println(e135searchInsert.searchInsert(nums,5));
    }
    public int searchInsert(int[] nums, int target) {
        int left=0,right = nums.length-1;
        while (left<=right){
            int middle = (left+right)/2;
            if(nums[middle]>target){
                right = middle-1;
            }else if(nums[middle]<target){
                left = middle+1;
            }else {
                return middle;
            }
        }
        return left;
    }
}
