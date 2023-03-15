package com.xiong.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiong
 * @Description 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * @date 2023-02-23 3:09 下午
 */
public class a15_three_sum {
    public static void main(String[] args) {
        int[] a = {-2,0,1,1,2};
        List<List<Integer>> lists = threeSum(a);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }



    //这种方式行不通
    public  static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        int min = 0;
        int max = nums.length-1;
        int preMinValue = Integer.MAX_VALUE;
        int preMaxValue = Integer.MAX_VALUE;
        ArrayList<List<Integer>> lists = new ArrayList<>();
        while (min+1 < max){
            int minValue = nums[min];
            int maxValue = nums[max];
            int sum1 = minValue+maxValue;
            if(sum1 == 0){
                for (int middle = min+1;middle<max;middle++){
                    if(nums[middle]==0 &&  (preMinValue!=minValue || preMaxValue!=maxValue)){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(minValue);
                        list.add(0);
                        list.add(maxValue);
                        lists.add(list);
                        preMinValue = minValue;
                        preMaxValue = maxValue;
                        break;
                    }
                }
                min++;
            }else if(sum1 >0){
                int j = min+1;
                while (nums[j]+sum1<=0){
                    if(nums[j]+sum1==0 &&  (preMinValue!=minValue || preMaxValue!=maxValue)){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(minValue);
                        list.add(nums[j]);
                        list.add(maxValue);
                        lists.add(list);
                        preMinValue = minValue;
                        preMaxValue = maxValue;
                        break;
                    }else {
                        j++;
                    }
                }
                max--;
            }else {
                int j = max-1;
                while (nums[j]+sum1>=0){
                    if(nums[j]+sum1==0 &&  (preMinValue!=minValue || preMaxValue!=maxValue)){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(minValue);
                        list.add(nums[j]);
                        list.add(maxValue);
                        lists.add(list);
                        preMinValue = minValue;
                        preMaxValue = maxValue;
                        break;
                    }else {
                        j--;
                    }
                }
                min++;
            }
        }
        return  lists;
    }

}
