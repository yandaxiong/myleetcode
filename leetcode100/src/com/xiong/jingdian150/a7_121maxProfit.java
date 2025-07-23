package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-17-17:40
 * 买卖股票的最佳时机
 */
public class a7_121maxProfit {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
    public static int maxProfit(int[] prices) {
        int res = 0;
        int low = Integer.MAX_VALUE;
        for(int i = 0;i<prices.length;i++){
            res = Math.max(res,prices[i]-low);
            low = Math.min(low,prices[i]);
        }
        return res;
    }

}
