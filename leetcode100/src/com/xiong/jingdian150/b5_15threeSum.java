package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author xiong
 * @create 2025-07-31-11:29
 */
public class b5_15threeSum {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ) {
            int right = nums.length-1;
            int tmp = -nums[i];
            for (int left = i + 1; left < right; ) {

                int tmpNum = nums[left]+nums[right];
                if (tmpNum == tmp) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    result.add(integers);
                    while (left+1 < right && nums[left] == nums[left+1] ) {left++;}
                    left++;
                    while (right-1 > left && nums[right] == nums[right-1]) {right--;}
                    right--;
                }else if (tmpNum < tmp) {
                    while (left+1 < right && nums[left] == nums[left+1]) {left++;}
                    left++;
                }else{
                    while (right-1 > left &&nums[right] == nums[right-1]) {right--;}
                    right--;
                }
            }
            while (i+1 < nums.length - 2 && nums[i] == nums[i+1]) {i++;}
            i++;
        }
        return result;

    }
}

//  -4    -3 -2 -1 -1 -1  0 0 1 2 3 4 4