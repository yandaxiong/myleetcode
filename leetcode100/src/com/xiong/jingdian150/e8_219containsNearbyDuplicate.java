package com.xiong.jingdian150;

import java.util.HashMap;

/**
 * @author xiong
 * @create 2025-08-11-20:13
 */
public class e8_219containsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer i1 = map.get(nums[i]);
                if (Math.abs(i1 - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);

        }
        return false;
    }
}
