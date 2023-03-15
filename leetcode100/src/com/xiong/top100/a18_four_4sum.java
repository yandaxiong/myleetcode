package com.xiong.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiong
 * @Description 四数之和
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * @date 2023-02-24 4:59 下午
 */
public class a18_four_4sum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> lists = fourSum(nums, 1000000000);
        System.out.println(lists);

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        if(nums.length<4){
            return resultList;
        }
        Arrays.sort(nums);
        int len = nums.length;
        if((long)nums[0]+(long)nums[1]+(long)nums[2]+(long)nums[3]>target){
            return  resultList;
        }
        if((long)nums[len-1]+(long)nums[len-2]+(long)nums[len-3]+(long)nums[len-4]<(long)target){
            return  resultList;
        }
        for (int a=0;a<len-3;a++){
            if(a>0 && nums[a]==nums[a-1]){
                continue;
            }
            for (int b=a+1;b<len-2;b++){
                if(b>a+1 && nums[b] == nums[b-1]) {
                    continue;
                }
                int c = b+1;
                int d = len-1;
                while (c<d){
                    if(c>b+1 && nums[c]==nums[c-1]){
                        c++;
                        continue;
                    }
                    if(d<len-1 && nums[d]==nums[d+1]){
                        d--;
                        continue;
                    }
                    int sum1 = nums[a]+nums[b]+nums[c]+nums[d];
                    if(sum1>target){
                        d--;
                    }else if(sum1<target){
                        c++;
                    }else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        resultList.add(list);
                        c++;
                    }
                }

            }
        }
        return resultList;
    }
}
