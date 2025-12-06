package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-11-26-17:20
 */
public class j3_63uniquePathsWithObstacles {
    public static void main(String[] args) {
        j3_63uniquePathsWithObstacles j3_63uniquePathsWithObstacles = new j3_63uniquePathsWithObstacles();
        System.out.println(j3_63uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}}));
//        System.out.println(j3_63uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{1}}));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] result  = new int[obstacleGrid.length][obstacleGrid[0].length];
        int tmp = 1;
        for (int i=0;i<obstacleGrid[0].length;i++){
            if(obstacleGrid[0][i]  == 1){
                tmp = 0;
            }
            result[0][i] = tmp;
        }
        tmp = 1;
        for (int i=0;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0]  == 1){
                tmp = 0;
            }
            result[i][0] = tmp;
        }
        for (int i=1;i<obstacleGrid.length;i++){
            for (int j=1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1){
                    result[i][j] = 0;
                    continue;
                }
                if(result[i-1][j]>0 && result[i][j-1]>0){
                    result[i][j] = result[i-1][j]+result[i][j-1];
                }else {
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
                }
            }
        }
        OutArrays.outArrays(result);
        return result[obstacleGrid.length-1][obstacleGrid[0].length-1];

    }
}
