package com.xiong.top100;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author xiong
 * @Description 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 * @date 2023-03-06 9:51 下午
 */
public class a64_minimum_path_sum {
    public static void main(String[] args) {
        a64_minimum_path_sum a64MinimumPathSum = new a64_minimum_path_sum();
        int[][] intervals = {{1,2,3},{4,5,6}};
        System.out.println(a64MinimumPathSum.minPathSum(intervals));
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        int sum = 0;
        for (int i=0;i<m;i++){
            sum+=grid[i][0];
            result[i][0]=sum;
        }
        sum = 0;
        for (int i=0;i<n;i++){
            sum+=grid[0][i];
            result[0][i]=sum;
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                result[i][j] = grid[i][j] + Math.min(result[i-1][j],result[i][j-1]);
            }
        }
        return result[m-1][n-1];
    }
}
