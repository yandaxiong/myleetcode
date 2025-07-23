package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.Arrays;

/**
 * @author xiong
 * @create 2025-07-22-11:22
 */
public class a92_274hIndex {
    public static void main(String[] args) {
        int[] nums = {3,0,6,1,5};
        System.out.println(hIndex(nums));

    }
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        OutArrays.outArrays(citations);
        int length = citations.length;
        int result = 0;
        for(int i = 0; i < length; i++){
            if(citations[i]>result){

            }
        }
        return result;
    }
}
