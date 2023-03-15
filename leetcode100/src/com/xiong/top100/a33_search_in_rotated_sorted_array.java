package com.xiong.top100;

/**
 * @author xiong
 * @Description 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题
 * @date 2023-03-02 11:18 上午
 */
public class a33_search_in_rotated_sorted_array {
    public static void main(String[] args) {
        a33_search_in_rotated_sorted_array a33 = new a33_search_in_rotated_sorted_array();
        int[] a = {1, 3};
        System.out.println(a33.search(a, 2));
    }

    public int search(int[] nums, int target) {
        return searchArray(nums, 0, nums.length - 1, target);
    }

    public int searchArray(int[] nums, int start, int end, int target) {
        int middle = (end - start) / 2 + start;
        if (start == end && nums[start] != target) {
            return -1;
        }
        if(middle==start && nums[start] != target && nums[end] != target){
            return -1;
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else if (nums[middle] == target) {
            return middle;
        }
        if (nums[start] < nums[middle]) {
            if (nums[start] < target && target < nums[middle]) {
                return searchArray(nums, start, middle, target);
            } else {
                return searchArray(nums, middle, end, target);
            }
        } else {
            if (nums[middle] < target && target < nums[end]) {
                return searchArray(nums, middle, end, target);
            } else {
                return searchArray(nums, start, middle, target);
            }
        }
    }

}
