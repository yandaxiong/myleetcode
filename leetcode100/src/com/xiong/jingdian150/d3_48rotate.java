package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-08-07-11:00
 */
public class d3_48rotate {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11}, { 2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        int cishu = matrix[0].length/2;
        int num = matrix.length-1;
        int maxIndex = matrix.length-1;
        for (int i = 0; i < cishu; i++) {
            for (int j = i,k=0; k < num; j++,k++) {
                int max = i+num;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[maxIndex-j][i];
                matrix[maxIndex-j][i] = matrix[max][maxIndex-j];
                matrix[max][maxIndex-j] = matrix[j][max];
                matrix[j][max] = tmp;
            }
            OutArrays.outArrays(matrix);
            num = num -2;
        }
    }
}
