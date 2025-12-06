package com.xiong.jingdian150_3;

import java.util.HashSet;

/**
 * @author xiong
 * @create 2025-11-14-15:33
 */
public class b5_52totalNQueens {
    public static void main(String[] args) {
        b5_52totalNQueens b552Solution = new b5_52totalNQueens();
        System.out.println(b552Solution.totalNQueens(4));
    }
    Integer result;
    public int totalNQueens(int n) {
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> diag1 = new HashSet<>();
        HashSet<Integer> diag2 = new HashSet<>();
        result = 0 ;
        backtrack(n, 0, cols, diag1, diag2);
        return result;
    }
    public void backtrack(int n, int row, HashSet<Integer> cols, HashSet<Integer> diag1, HashSet<Integer> diag2){
        if(row>=n){
            result++;
        }
        for (int col=0;col<n;col++){
            if(!cols.contains(col) && !diag1.contains(row+col) && !diag2.contains(row-col)){
                cols.add(col);
                diag1.add(row+col);
                diag2.add(row-col);
                backtrack(n, row+1, cols, diag1, diag2);
                cols.remove(col);
                diag1.remove(row+col);
                diag2.remove(row-col);
            }
        }
    }
}
