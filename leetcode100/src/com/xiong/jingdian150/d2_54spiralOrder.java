package com.xiong.jingdian150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong
 * @create 2025-08-06-20:24
 */
public class d2_54spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,}, { 4,5,6}, {7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        boolean isAddCol = true;
        boolean isAddRow = true;
        int colLength = matrix[0].length;
        int rowLength = matrix.length;
        boolean  calCol = true;
        int panduan = colLength;
        int row = 0;
        int col = -1;
        while (panduan != 0) {
            if (calCol) {
                for (int i = 0; i < colLength; i++) {
                    if(isAddCol){
                        col++;
                    }else {
                        col--;
                    }
                    res.add(matrix[row][col]);
                }
                rowLength--;
                isAddCol = !isAddCol;
                panduan = rowLength;
            }else {
                for (int i = 0; i < rowLength; i++) {
                    if(isAddRow){
                        row++;
                    }else {
                        row--;
                    }
                    res.add(matrix[row][col]);
                }
                colLength--;
                isAddRow = !isAddRow;
                panduan = colLength;
            }
            calCol = !calCol;

        }
        return res;
    }
}
