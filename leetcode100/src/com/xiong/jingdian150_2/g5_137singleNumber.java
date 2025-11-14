package com.xiong.jingdian150_2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiong
 * @create 2025-11-12-11:30
 */
public class g5_137singleNumber {
    public static void main(String[] args) {
        g5_137singleNumber e5137singleNumber = new g5_137singleNumber();
        int[] nums = {2,2,3,2};
        System.out.println(e5137singleNumber.singleNumber(nums));
    }
    /**
     * 在数组中找出只出现一次的数字，其他数字都出现三次
     * 使用位运算的方法，统计每一位上1出现的次数，如果不能被3整除，
     * 说明只出现一次的数字在该位上为1
     * 
     * @param nums 输入的整数数组，除了一个元素只出现一次外，其余每个元素都出现三次
     * @return 只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        // 遍历32位整数的每一位
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            // 统计所有数字在第i位上1的个数
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            // 如果该位上1的个数不能被3整除，说明只出现一次的数字在该位上为1
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }


}
