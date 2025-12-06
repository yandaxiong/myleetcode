package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xiong
 * @create 2025-11-25-19:42
 */
public class g6_149maxPoints {
    public static void main(String[] args) {
        g6_149maxPoints g6_149maxPoints = new g6_149maxPoints();
        System.out.println(g6_149maxPoints.maxPoints(new int[][]{{1,1},{2,2},{3,3}}));
    }


    public int maxPoints(int[][] points) {
        int result = 0;
        HashMap<Double, Integer> rateMap;
        for (int i=0;i<points.length;i++){
            rateMap = new HashMap<>();
            for (int j=0;j<points.length;j++){
                if(i!=j){
                    double rate = (double) (points[j][1] - points[i][1]) /(points[j][0]-points[i][0]);
                    if(rateMap.containsKey(rate)){
                        rateMap.put(rate,rateMap.get(rate)+1);
                    }else{
                        rateMap.put(rate,1);
                    }
                }
            }
            for (Integer num:rateMap.values()){
                result = Math.max(result,num);
            }
        }
        return  result+1;
    }
}
