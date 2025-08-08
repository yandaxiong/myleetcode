package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-08-07-14:37
 */
public class d4_73setZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0}, { 3,4,5,2}, {1,3,1,5}};
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        ArrayList<Integer> rowIndex = new ArrayList<>();
        ArrayList<Integer> colIndex = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowIndex.add(i);
                    colIndex.add(j);
                }
            }
        }
        for (int i = 0; i < rowIndex.size(); i++) {
            for (int j = 0; j <  matrix[0].length; j++) {
                matrix[rowIndex.get(i)][j] = 0;
            }
        }
        for (int i = 0; i < colIndex.size(); i++) {
            for (int j = 0; j <  matrix.length; j++) {
                matrix[j][colIndex.get(i)] = 0;
            }
        }
        OutArrays.outArrays(matrix);
    }

}
