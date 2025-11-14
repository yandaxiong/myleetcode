package com.xiong.jingdian150_2;

import com.xiong.utils.OutArrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiong
 * @create 2025-11-11-19:54
 */
public class f1_909snakesAndLadders {
    public static void main(String[] args) {
        f1_909snakesAndLadders f1909snakesAndLadders = new f1_909snakesAndLadders();
        int[][] board ={{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
//        OutArrays.outArrays(f1909snakesAndLadders.id2rc(10,6));
                System.out.println(f1909snakesAndLadders.snakesAndLadders(board));
    }
    /**
     * 计算蛇梯棋游戏中到达终点的最少步数
     * 使用广度优先搜索(BFS)算法寻找最短路径
     * 
     * @param board n×n的整数矩阵，表示棋盘
     *              board[i][j] = -1 表示该位置为空
     *              board[i][j] > 0 表示该位置有梯子或蛇，会跳转到对应的格子
     * @return 到达终点(n*n)所需的最少步数，如果无法到达则返回-1
     */
    public int snakesAndLadders(int[][] board) {
        int len = board[0].length;
        boolean[] visited = new boolean[len*len+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i=1 ;i<=6;i++){
                int next = cur[0] + i;

                int[] pos = id2rc(next, len);
                if(board[pos[0]][pos[1]] != -1 ){
                    next = board[pos[0]][pos[1]];
                }
                if(next == len*len){
                    return cur[1]+1;
                }
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(new int[]{next,cur[1]+1});
                }
            }
        }
        return  -1;
    }

    /**
     * 将棋盘上的编号转换为二维数组的行列坐标
     * 蛇梯棋的编号是蛇形排列的，从左下角开始，偶数行从左到右，奇数行从右到左
     * 
     * @param id 编号，从1开始
     * @param n  棋盘边长
     * @return 包含行列坐标的数组，[0]为行，[1]为列，行列从0开始计数
     */
    public int[] id2rc(int id, int n) {
       int  row = (id-1)/n;
       int  col = (id-1)%n;
       if(row%2==1){
           col = n-col-1;
       }
       return  new int[]{n-1-row,col};
    }

}
