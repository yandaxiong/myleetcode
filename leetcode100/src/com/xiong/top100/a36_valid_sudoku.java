package com.xiong.top100;

/**
 * @author xiong
 * @Description  有效的数独
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用'.'表示。
 *
 * @date 2023-03-02 4:15 下午
 */
public class a36_valid_sudoku {
    public static void main(String[] args) {
        a36_valid_sudoku a36 = new a36_valid_sudoku();
    }
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] matrixs = new int[3][3][9];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                char c = board[i][j];
                if('.'!=c) {
                    int indexNum = c - '0' - 1;
                    rows[i][indexNum]++;
                    columns[j][indexNum]++;
                    matrixs[i / 3][j / 3][indexNum]++;
                    if (rows[i][indexNum] > 1 || columns[j][indexNum] > 1 || matrixs[i / 3][j / 3][indexNum] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
