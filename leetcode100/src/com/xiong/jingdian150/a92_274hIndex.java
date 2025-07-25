package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xiong
 * @create 2025-07-22-11:22
 * H 指数
 */
public class a92_274hIndex {
    public static void main(String[] args) {
        int[] nums = {1,2,6,6,5};
        System.out.println(hIndex(nums));

    }
    public static int hIndex2(int[] citations) {
        int[] tmp = new int[citations.length];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length) {
                tmp[citations.length - 1]++;
            } else if (citations[i] >0) {
                tmp[citations[i]-1]++;
            }
        }
        OutArrays.outArrays(tmp);
        int maxCount = 0;
        for (int i = tmp.length-1; i >=0 ; i--) {
            if(tmp[i]+maxCount >= i+1){
                return i+1;
            }else {
                maxCount=maxCount+tmp[i];
            }
        }
        return maxCount;
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        OutArrays.outArrays(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }


}
