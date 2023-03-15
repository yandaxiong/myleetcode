package com.xiong.top100;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @Description 颜色分类
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * @date 2023-03-07 8:59 下午
 */
public class a75_sort_colors {
    public static void main(String[] args) {
        a75_sort_colors a75SortColors = new a75_sort_colors();
        int[] nums = {2,0,1};
        a75SortColors.sortColors(nums);
    }
    public void sortColors(int[] nums) {
        OutArrays.outArrays(nums);
        int left = 0;
        int right = nums.length-1;
        int present = 0;
        while (present<=right){
            if(nums[present]==0){
                nums[present] = nums[left];
                nums[left] = 0;
                left++;
            }else if(nums[present]==2){
                nums[present] = nums[right];
                nums[right] = 2;
                right--;
            }
            if(left>present || nums[present]==1){
                present++;
            }
        }
        OutArrays.outArrays(nums);
    }
}
