package com.xiong.top100;

/**
 * @author xiong
 * @Description 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @date 2023-03-02 3:55 下午
 */
public class a35_search_insert_position {
    public static void main(String[] args) {
        a35_search_insert_position a35 = new a35_search_insert_position();
        int[] a = {1,3,5,6};
        System.out.println(a35.searchInsert(a,4));
    }
    public int searchInsert(int[] nums, int target) {
        int left=0,right = nums.length-1,ans;
        while (left<=right){
            int middle = (left+right)/2;
            if(nums[middle]>target){
                right = middle-1;
            }else if(nums[middle]<target) {
                left = middle+1;
            }else {
                return middle;
            }
        }
        return  left;

    }
}
