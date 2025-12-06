package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-11-27-20:51
 */
public class j6_72minDistance {
    public static void main(String[] args) {
        j6_72minDistance j6_72minDistance = new j6_72minDistance();
        System.out.println(j6_72minDistance.minDistance("horse", "ros"));
    }
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if(length2*length1==0){
            return length1+length2;
        }
        int[][] ints = new int[length1+1][length2+1];
        ints[0][0] = 0;
        for (int i=1;i<=length1;i++){
            ints[i][0] = i;
        }
        for (int j=1;j<=length2;j++){
            ints[0][j] = j;
        }
        for (int i=1;i<=length1;i++){
            for (int j=1;j<=length2;j++){
                int left = ints[i-1][j]+1;
                int down = ints[i][j-1]+1;
                int left_down = ints[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    left_down = left_down+1;
                }
                ints[i][j] =  Math.min(left,Math.min(down,left_down));
            }
        }
        return ints[length1][length2];
    }
}
