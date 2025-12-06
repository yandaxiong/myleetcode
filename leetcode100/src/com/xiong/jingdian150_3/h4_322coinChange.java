package com.xiong.jingdian150_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiong
 * @create 2025-11-26-11:09
 */
public class h4_322coinChange {
    public static void main(String[] args) {
        h4_322coinChange h4_322coinChange = new h4_322coinChange();
        System.out.println(h4_322coinChange.coinChange(new int[]{2}, 3));
    }
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for (int coin:coins){
                if(i-coin >= 0 && dp[i-coin] != -1){
                   min = Math.min(min, dp[i-coin]+1);
                }
            }
            if (min == Integer.MAX_VALUE){
                dp[i] = -1;
            }else {
                dp[i] = min;
            }
        }
        return dp[amount];
    }
}
