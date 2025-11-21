package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-19-16:57
 */
public class e2_74searchMatrix {
    public static void main(String[] args) {
        e2_74searchMatrix e274searchMatrix = new e2_74searchMatrix();
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(e274searchMatrix.searchMatrix(matrix, 51));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix[0].length-1;
        int row=matrix.length;
        for (int i=0;i<matrix.length;i++){
            if(matrix[i][0]<=target && matrix[i][right]>=target){
                row = i;
                break;
            }
        }
        if (row==matrix.length){
            return false;
        }
        while (left<=right){
            int middle = (left+right)/2;
            if(matrix[row][middle]>target){
                right = middle-1;
            }else if(matrix[row][middle]<target){
                left = middle+1;
            }else {
                return true;
            }
        }
        return false;

    }
}
