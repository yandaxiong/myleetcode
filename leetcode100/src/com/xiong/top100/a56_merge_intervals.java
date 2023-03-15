package com.xiong.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author xiong
 * @Description 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * @date 2023-03-06 8:57 下午
 */
public class a56_merge_intervals {
    public static void main(String[] args) {
        a56_merge_intervals a56MergeIntervals = new a56_merge_intervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] resultRows = a56MergeIntervals.merge(intervals);
        for (int[] row:resultRows){
            System.out.println(Arrays.toString(row));
        }
    }
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ArrayList<int[]> resultList = new ArrayList<>();
        for (int[] row: intervals) {
           if(resultList.size()==0 || resultList.get(resultList.size()-1)[1]<row[0] ){
               resultList.add(row);
           }else {
               resultList.set( resultList.size()-1  ,
                       new int[]{resultList.get(resultList.size()-1)[0], Math.max(resultList.get(resultList.size()-1)[1],row[1]) });
           }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }
}
