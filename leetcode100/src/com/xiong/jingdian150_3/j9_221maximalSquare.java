package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

import java.text.Format;

/**
 * @author xiong
 * @create 2025-12-03-16:20
 */
public class j9_221maximalSquare {
    public static void main(String[] args) {
        j9_221maximalSquare j9_221maximalSquare = new j9_221maximalSquare();
        System.out.println(j9_221maximalSquare.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int result  = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;

                    }
                }else {
                    dp[i][j] = 0;
                }
                result = Math.max(result,dp[i][j]);

            }
        }

        return result*result;
    }


}
