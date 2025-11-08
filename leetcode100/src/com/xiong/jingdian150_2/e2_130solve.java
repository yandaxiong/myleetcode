package com.xiong.jingdian150_2;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-09-10-17:33
 */
public class e2_130solve {
    public static void main(String[] args) {
        char[][] matrix = {{'0','0'}, {'0','0'}};
        new e2_130solve().solve(matrix);
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {return;}
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < c; i++) {
            dfs(board,0,i);
            dfs(board,r-1,i);
        }
        for (int i = 0; i < r; i++) {
            dfs(board,i,0);
            dfs(board,i,c-1);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
        OutArrays.outArrays(board);

    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 'X' || grid[r][c] == '.') {
            return;
        }

        grid[r][c] = '.';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
