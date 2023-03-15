package com.xiong.top100;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @Description 编辑距离
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * @date 2023-03-07 11:01 上午
 */
public class a72_edit_distance {
    public static void main(String[] args) {
        a72_edit_distance a72EditDistance = new a72_edit_distance();
        String word1 = "horse", word2 = "ros";
        System.out.println(a72EditDistance.minDistance(word1,word2));
    }
    public int minDistance(String word1, String word2) {
        int w1Len = word1.length();
        int w2Len = word2.length();
        int[][] dp = new int[w1Len+1][w2Len+1];
        dp[0][0]=0;
        for (int i=1;i<=w1Len;i++){
            dp[i][0] = i;
        }
        for (int i=1;i<=w2Len;i++){
            dp[0][i] = i;
        }
        OutArrays.outArrays(dp);
        for (int row=1;row<=w1Len;row++){
            for (int column=1;column<=w2Len;column++){
                if(word1.charAt(row-1) == word2.charAt(column-1)){
                    dp[row][column] = dp[row-1][column-1];
                }else {
                    dp[row][column] = Math.min(dp[row - 1][column - 1],
                            Math.min(dp[row][column - 1], dp[row - 1][column])) + 1;
                }
            }
        }
        return dp[w1Len][w2Len];
    }
}
