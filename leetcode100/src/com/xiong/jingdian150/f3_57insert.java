package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xiong
 * @create 2025-08-12-20:40
 */
public class f3_57insert {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        OutArrays.outArrays(insert(intervals, newInterval));
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<int[]> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        map.put(newInterval[0], newInterval[1]);
        list.add(newInterval[0]);
        for (int[] interval : intervals) {
            map.put(interval[0], Math.max(map.getOrDefault(interval[0], 0)   , interval[1]) );
            list.add(interval[0]);
        }
        list.sort(Integer::compareTo);
        Integer tmpLeft = list.get(0);
        Integer tmpRight = map.get(tmpLeft);
        for (int i = 1; i < list.size(); i++) {
            Integer i1 = list.get(i);
            Integer i2 = map.get(i1);
            if(i1>tmpRight){
                int[] temp = {tmpLeft, tmpRight};
                result.add(temp);
                tmpLeft = i1;
                tmpRight = i2;
            }else {
                tmpRight = Math.max(tmpRight,i2);
            }
        }
        result.add(new int[]{tmpLeft, tmpRight});
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
