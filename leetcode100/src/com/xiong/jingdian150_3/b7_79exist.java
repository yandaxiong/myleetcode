package com.xiong.jingdian150_3;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-11-17-18:32
 */
public class b7_79exist {
    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}};
        String word = "ba";
        boolean exist = new b7_79exist().exist(board, word);
        System.out.println(exist);
    }


    public boolean exist(char[][] board, String word) {
        char[] charArray = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (backtrack(charArray,visited,board,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[] charArray, boolean[][] visited, char[][] board, int num, int i, int j) {
        if(num>=charArray.length){
            return  true;
        }
        if (board[i][j] == charArray[num]){
            if(num+1>=charArray.length){
                return  true;
            }
            boolean result = false;
            visited[i][j] = true;
            if(i-1>=0 && !visited[i-1][j] ){
                result = result || backtrack(charArray,visited,board,num+1,i-1,j);
            }
            if(j-1>=0 && !visited[i][j-1]){
                result = result || backtrack(charArray,visited,board,num+1,i,j-1);
            }
            if(i+1<board.length && !visited[i+1][j]){
                result = result || backtrack(charArray,visited,board,num+1,i+1,j);
            }
            if(j+1<board[0].length && !visited[i][j+1]){
                result = result || backtrack(charArray,visited,board,num+1,i,j+1);
            }
            visited[i][j] = false;
            return result;
        }else {
            return false;
        }
    }
}
