package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-19-19:20
 */
public class e4_33search {
    public static void main(String[] args) {
        e4_33search e433search = new e4_33search();
        int[] nums = new int[]{3,1};
        System.out.println(e433search.search(nums, 1));
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int middle = (left+right)/2;
           if(target==nums[middle]){
               return middle;
           }else if(target<nums[middle]){
               if(isOrder(nums,left,middle)){
                   if(nums[left]<=target){
                       right = middle-1;
                   }else {
                        left = middle+1;
                   }
               }else {
                   right = middle-1;
               }
           }else{
               if(isOrder(nums,middle,right)){
                   if(nums[right]>=target){
                       left = middle+1;
                   }else {
                       right = middle-1;
                   }

               }else {
                   left = middle+1;
               }
           }

        }
        return -1;
    }
    public boolean isOrder(int[] nums,int left,int right){
        if (nums[left]<=nums[right]){
            return true;
        }else {
            return false;
        }
    }


}
