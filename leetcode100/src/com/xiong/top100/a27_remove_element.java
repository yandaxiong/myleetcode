package com.xiong.top100;

/**
 * @author xiong
 * @Description 移除元素
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @date 2023-02-28 8:40 下午
 */
public class a27_remove_element {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,2,3,4,5,5,5};
        System.out.println(removeElement(a,1));
    }
    public static  int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        int result = 0;
        for (int i=0;i<nums.length;i++){
            if(val != nums[i]){
                nums[result] = nums[i];
                result++;
            }
        }
        return  result;
    }
}
