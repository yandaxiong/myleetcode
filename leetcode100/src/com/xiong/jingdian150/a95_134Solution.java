package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-07-29-17:46
 */
public class a95_134Solution {
    public static void main(String[] args) {
        int[] nums = {2,3,4};
        int[] nums2 = {3,4,3};
        System.out.println(canCompleteCircuit(nums, nums2));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i] ;
            sum = sum + diff[i];
        }
        if(sum < 0 ) return -1;
        int start = -1;
        int index = 0;
        int tmp = 0;
        for (int i = 0; i < diff.length; i++) {
            if(tmp + diff[(index+i)%diff.length] >=0 ){
                if(start == -1)  start = index;
                tmp = tmp + diff[(index+i)%diff.length];
            }else{
                start = -1;
                index = index + i+1;
                tmp = 0 ;
                i = -1;
                if(index > diff.length)  break;
            }
        }

        return start;
    }
}