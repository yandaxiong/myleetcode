package com.xiong.jingdian150_3;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-11-14-15:33
 */
public class b5_52Solution {
    public static void main(String[] args) {
        b5_52Solution b552Solution = new b5_52Solution();
        System.out.println(b552Solution.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        int[][] xyList = new int[n][n];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                xyList[i][j] = 1;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int tmp=1;
        backtrack(xyList,n,result,tmp);

        return result.size();
    }

    private void backtrack(int[][] xyList, int n, ArrayList<Integer> result,int tmp) {
        if (tmp>n){
            result.add(1);
            return;
        }
        if (xyList.size()<0){
            return;
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                int[] ints = {i, j};
                if(xyList.contains(ints)){
                }
            }
        }
    }


    private  void remove(int[][] xyList,int[]xy,int length){
        int x = xy[0];
        int y = xy[1];
        for (int i=0;i<xyList.length;i++){

        }



//            if (xy1[0] == x || xy1[1] == y || xy1[0]+xy1[1]==x+y || xy1[0]-xy1[1]==x-y){
//
//            }
    }

    private  boolean isValid(int[] xy,ArrayList<int[]> xyList){
        int x = xy[0];
        int y = xy[1];
    }
}
