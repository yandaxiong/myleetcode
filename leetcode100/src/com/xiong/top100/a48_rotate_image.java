package com.xiong.top100;

import java.util.Arrays;

/**
 * @author xiong
 * @Description 旋转图像
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * @date 2023-03-03 5:46 下午
 */
public class a48_rotate_image {

    public static void main(String[] args) {
        a48_rotate_image a48 = new a48_rotate_image();
        int[][] a =  {{1,2,3},{4,5,6},{7,8,9}};
        a48.rotate(a);
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));

    }
    public void rotate(int[][] matrix) {
        int allLen = matrix.length-1;
        int len = matrix.length%2==0?matrix.length/2:matrix.length/2+1;
        for (int i=0;i<matrix.length/2;i++){
            for (int j=0;j<len;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[allLen-j][i];
                matrix[allLen-j][i] = matrix[allLen-i][allLen-j];
                matrix[allLen-i][allLen-j] = matrix[j][allLen-i];
                matrix[j][allLen-i] = tmp;
            }
        }

    }
}
