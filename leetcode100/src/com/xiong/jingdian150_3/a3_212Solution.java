package com.xiong.jingdian150_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiong
 * @create 2025-11-13-20:05
 */
public class a3_212Solution {

    public static void main(String[] args) {
        a3_212Solution a3_212Solution = new a3_212Solution();
        List<String> list = a3_212Solution.findWords(
                new char[][]{
                        {'a','b','c'},
                        {'a','e','d'},
                        {'a','f','g'}},
                new String[]{"eaafgdcba"});

        System.out.println( list);

    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word:words){
            for1:
            for (int i=0;i<board.length;i++){
                for (int j=0;j<board[0].length;j++){
                    boolean[][] booleans = new boolean[board.length][board[0].length];
                    char c = word.charAt(0);
                    if (board[i][j]==c){
                        booleans[i][j]=true;
                        if(dfs(board,word,1,i,j,booleans)){
                            result.add(word);
                            break for1;
                        }
                    }
                }
            }

        }
        return result;
    }

    private boolean dfs(char[][] board,String word,int index,int x,int y,boolean[][] visited) {
        if(index==word.length()){
            return true;
        }
        char c = word.charAt(index);
        int m = visited.length;
        int n = visited[0].length;
        if(x-1>=0 && !visited[x-1][y] && board[x-1][y]==c ){
            visited[x-1][y] = true;
            if( dfs(board, word,index+1,x-1, y, visited)){
                return true;
            }
            visited[x-1][y] = false;
        }
        if(x+1<m && !visited[x+1][y] && board[x+1][y]==c ){
            visited[x+1][y] = true;
            if( dfs(board, word,index+1,x+1, y, visited)){
                return true;
            }
            visited[x+1][y] = false;
        }
        if(y-1>=0 && !visited[x][y-1] && board[x][y-1]==c ){
            visited[x][y-1] = true;
            if( dfs(board, word,index+1,x, y-1, visited)){
                return true;
            }
            visited[x][y-1] = false;
        }
        if(y+1<n && !visited[x][y+1] && board[x][y+1]==c ){
            visited[x][y+1] = true;
            if( dfs(board, word,index+1,x, y+1, visited)){
                return true;
            }
            visited[x][y+1] = false;
        }
        return false;
    }
}
