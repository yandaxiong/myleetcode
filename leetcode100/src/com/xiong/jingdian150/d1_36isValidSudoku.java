package com.xiong.jingdian150;

import java.util.Arrays;

/**
 * @author xiong
 * @create 2025-08-05-20:54
 */
public class d1_36isValidSudoku {
    public static void main(String[] args) {
        String[][] board = {{"5","3",".",".","7",".",".",".","."}
                        ,{"6",".",".","1","9","5",".",".","."}
                        ,{".","9","8",".",".",".",".","6","."}
                        ,{"8",".",".",".","6",".",".",".","3"}
                        ,{"4",".",".","8",".","3",".",".","1"}
                        ,{"7",".",".",".","2",".",".",".","6"}
                        ,{".","6",".",".",".",".","2","8","."}
                        ,{".",".",".","4","1","9",".",".","5"}
                        ,{".",".",".",".","8",".",".","7","9"}};
        char[][] sudoku = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = board[i][j].charAt(0);
            }
        }
        System.out.println(isValidSudoku(sudoku));

    }
    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] diag = new int[3][3][9];
        System.out.println(Arrays.deepToString(board));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c1 = board[i][j];
                if (c1 != '.') {
                    int c =  c1 - '0' -1 ;
                    row[i][c] = row[i][c]+1;
                    if (row[i][c]>1) return false;
                    col[j][c] = col[j][c]+1;
                    if (col[j][c]>1) return false;
                    diag[i/3][j/3][c] = diag[i/3][j/3][c]+1;
                    if (diag[i/3][j/3][c]>1) return false;
                }

            }
        }
        return true;
    }
}
