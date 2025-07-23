package com.xiong.jingdian150;

/**
 * @author xiong
 * @create 2025-07-17-20:25
 * 买卖股票的最佳时机 II
 */
public class a8_122maxProfit2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(maxProfit(nums));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int[] diff = new int[prices.length-1];
        for(int i = 0; i < prices.length-1; i++){
            diff[i] = prices[i+1]-prices[i];
        }
        for(int i = 0; i <diff.length; i++){
            if(diff[i] > 0){
                maxProfit = maxProfit+diff[i];
            }
        }
        return maxProfit;
    }
}
