package com.xiong.jingdian150_3;

import java.util.HashMap;

/**
 * @author xiong
 * @create 2025-11-25-20:26
 */
public class h2_198rob {
    public static void main(String[] args) {
        h2_198rob h2_198rob = new h2_198rob();
        System.out.println(h2_198rob.rob(new int[]{2,7,9,3,1}));
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,nums[0]);
        map.put(1, Math.max(nums[0],nums[1]));
        return rob2(nums, map,nums.length-1);
    }
    public int rob2(int[] nums, HashMap<Integer,Integer> map,int tmpNum) {
        if (map.containsKey(tmpNum)){
            return map.get(tmpNum);
        }
        int i = rob2(nums, map, tmpNum - 1);
        int i2 = rob2(nums, map, tmpNum - 2)+nums[tmpNum];
        int max = Math.max(i, i2);
        map.put(tmpNum,max);
        return max;
    }

}
