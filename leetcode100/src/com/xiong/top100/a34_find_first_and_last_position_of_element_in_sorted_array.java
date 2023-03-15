package com.xiong.top100;

import java.util.Arrays;

/**
 * @author xiong
 * @Description  在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 *
 * @date 2023-03-02 2:40 下午
 */
public class a34_find_first_and_last_position_of_element_in_sorted_array {
    public static void main(String[] args) {
        a34_find_first_and_last_position_of_element_in_sorted_array a34 = new a34_find_first_and_last_position_of_element_in_sorted_array();
        int[] a = {5,7,7,8,8,10};
        int[] ints = a34.searchRange2(a, 10);
        System.out.println(Arrays.toString(ints));
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        return search(nums, 0, nums.length - 1, target);
    }
    public int[] search(int[] nums,int start,int end,int target){
        if(nums[start]==target ){
            int size = targetSize(nums, start, "front");
            return new int[]{start,start+size-1};
        }
        if(nums[end]==target){
            int size = targetSize(nums, end, "back");
            return new int[]{end-size+1,end};
        }
        int middle = (end-start)/2 + start;
        if(middle==start || start==end || nums[start]>target || nums[end]<target){
            return new int[]{-1,-1};
        }
        if(nums[middle]<target){
            return search(nums,middle+1,end,target);
        }else if(nums[middle]>target){
            return search(nums,start,middle,target);
        }else {
            int size = targetSize(nums, middle, "back");
            int backSize = 0;
            if(nums[middle+1]==target){
                backSize = targetSize(nums, middle+1, "front");
            }
            return new int[]{middle-size+1,middle+backSize};
        }
    }
    public int targetSize(int[] nums,int index,String direction){
        int size = 0;
        if("front".equals(direction)){
            for (int i=index;i<nums.length;i++){
                if(nums[i]==nums[index]){
                    size++;
                }else {
                    break;
                }
            }
        }
        if("back".equals(direction)){
            for (int i=index;i>=0;i--){
                if(nums[i]==nums[index]){
                    size++;
                }else {
                    break;
                }
            }
        }
        return  size;
    }
//------------------------------------------------------------------------------------------------------
    public int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


}
