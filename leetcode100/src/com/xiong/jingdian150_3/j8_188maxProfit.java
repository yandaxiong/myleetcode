package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-12-06-15:16
 */
public class j8_188maxProfit {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2,4,1};
        System.out.println(new j8_188maxProfit().maxProfit(k, prices));

    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] bugs = new int[k];
        int[] sells = new int[k];
        for (int i=0;i<k;i++){
            bugs[i] = -prices[0];
            sells[i] = 0;
        }
        for (int i = 1; i < n; ++i) {
            bugs[0] = Math.max(bugs[0], -prices[i]);
            sells[0] = Math.max(sells[0], bugs[0] + prices[i]);
            for (int j=1;j<k;j++){
                bugs[j] = Math.max(bugs[j], sells[j-1]-prices[i]);
                sells[j] = Math.max(sells[j], bugs[j] + prices[i]);
            }
        }
        return sells[k-1];
    }
}
