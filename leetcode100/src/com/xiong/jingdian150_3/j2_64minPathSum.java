package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-26-17:13
 */
public class j2_64minPathSum {
    public static void main(String[] args) {
        j2_64minPathSum j2_64minPathSum = new j2_64minPathSum();
        System.out.println(j2_64minPathSum.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }


    public int minPathSum(int[][] grid) {
        int[][] result  = new int[grid.length][grid[0].length];
        result[0][0] = grid[0][0];
        for (int i=1;i<grid[0].length;i++){
            result[0][i] = result[0][i-1]+grid[0][i];
        }
        for (int i=1;i<grid.length;i++){
            result[i][0] = result[i-1][0]+grid[i][0];
        }

        for (int i=1;i<grid.length;i++){
            for (int j=1;j<grid[0].length;j++){
                int min = Math.min(result[i - 1][j], result[i][j - 1]);
                result[i][j] = min + grid[i][j];
            }
        }
        return result[grid.length-1][grid[0].length-1];
    }

}
