package com.xiong.top100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiong
 * @Description 单词搜索
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @date 2023-03-09 3:27 下午
 */
public class a79_word_search {
    public static void main(String[] args) {
        a79_word_search a79WordSearch = new a79_word_search();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        boolean exist = a79WordSearch.exist(board, word);
        System.out.println(exist);

    }
    public boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int columnLen = board[0].length;
        boolean[][] visited = new boolean[rowLen][columnLen];
        for (int i=0;i<rowLen;i++) {
            for (int j = 0; j < columnLen; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }


//    错误做法，没有回溯
    public boolean exist2(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i=0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                if(board[i][j]==words[0]){
                    ArrayList<String> flagList = new ArrayList<>();
                    flagList.add(i+"_"+j);
                    int row=i,column=j;
                    for (int k=1;k<words.length;k++){
                        char c = words[k];
                        if(row-1>=0 && board[row-1][column]==c && !flagList.contains((row-1) +"_"+ column)){
                            flagList.add((row-1) +"_"+ column);
                            row = row-1;
                        }else if(column-1>=0 && board[row][column-1]==c && !flagList.contains((row) +"_"+ (column-1))){
                            flagList.add((row) +"_"+ (column-1));
                            column = column-1;
                        }else if(row+1<board.length && board[row+1][column]==c && !flagList.contains((row+1) +"_"+ column)){
                            flagList.add((row+1) +"_"+ column);
                            row = row+1;
                        }else if(column+1<board[0].length && board[row][column+1]==c && !flagList.contains((row) +"_"+ (column+1))){
                            flagList.add((row) +"_"+ (column+1));
                            column = column+1;
                        }else {
                            break;
                        }
                        if(k==words.length-1){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
