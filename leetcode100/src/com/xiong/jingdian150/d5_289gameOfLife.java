package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.Arrays;
import java.util.Map;

/**
 * @author xiong
 * @create 2025-08-07-14:54
 */
public class d5_289gameOfLife {
    public static void main(String[] args) {
        int[][] matrix = {{1,1}, { 1,0}};
        d5_289gameOfLife d5289gameOfLife = new d5_289gameOfLife();
        d5289gameOfLife.gameOfLife(matrix);
    }
    public   void gameOfLife(int[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        int[][] visited = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int rStart = i-1<0?0:i-1;
                int cStart = j-1<0?0:j-1;
                int rEnd = i+1<rowLen?i+1:rowLen-1;
                int cEnd = j+1<colLen?j+1:colLen-1;
                int lifeNum = 0;
                for (int r = rStart; r <= rEnd; r++) {
                    for (int c = cStart; c <= cEnd; c++) {
                        if(r==i && c==j){continue;}
                        if( board[r][c]==1){
                            lifeNum++;
                        }
                    }
                }
                if(board[i][j] == 1){
                    if(lifeNum<2){
                        visited[i][j] = 0;
                    } else if(lifeNum==2 || lifeNum==3){
                        visited[i][j] = 1;
                    }else {
                        visited[i][j] = 0;
                    }
                }else {
                    if(lifeNum==3){
                        visited[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                board[i][j] = visited[i][j];
            }
        }
        OutArrays.outArrays(board);
    }
}
