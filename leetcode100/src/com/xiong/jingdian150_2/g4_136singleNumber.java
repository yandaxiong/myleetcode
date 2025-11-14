package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-11-12-11:17
 */
public class g4_136singleNumber {
    public static void main(String[] args) {
        g4_136singleNumber g3136singleNumber = new g4_136singleNumber();
        int[] nums = {4,1,2,1,2};
        System.out.println(g3136singleNumber.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
