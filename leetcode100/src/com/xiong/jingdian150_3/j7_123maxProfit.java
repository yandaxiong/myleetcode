package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

import java.util.Arrays;

/**
 * @author xiong
 * @create 2025-12-02-20:35
 */
public class j7_123maxProfit {
    public static void main(String[] args) {
        j7_123maxProfit j7_123maxProfit = new j7_123maxProfit();
        System.out.println(j7_123maxProfit.maxProfit(new int[]{14,9,10,12,4,8,1,16}));
//        System.out.println(j7_123maxProfit.maxProfit2("33500314"));

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
            System.out.println(buy1+" "+sell1+" "+buy2+" "+sell2);
        }
        return sell2;
    }



}
