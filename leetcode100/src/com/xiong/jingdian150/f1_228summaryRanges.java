package com.xiong.jingdian150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong
 * @create 2025-08-12-19:41
 */
public class f1_228summaryRanges {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> strings = new ArrayList<>();
        if(nums.length == 0) return strings;
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] != nums[i]-1) {
                if(start!=nums[i - 1]) {
                    strings.add(start + "->" + nums[i - 1]);
                }else {
                    strings.add(start+"");
                }
                start = nums[i];
            }
        }
        if(start!=nums[nums.length - 1]) {
            strings.add(start + "->" + nums[nums.length - 1]);
        }else {
            strings.add(start+"");
        }
        return  strings;
    }
}
