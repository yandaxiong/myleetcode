package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong
 * @create 2025-11-26-15:12
 */
public class j1_120minimumTotal {
    public static void main(String[] args) {

        j1_120minimumTotal j1120minimumTotal = new j1_120minimumTotal();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        lists.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(-2);
        list2.add(-3);
        lists.add(list2);
//        ArrayList<Integer> list3 = new ArrayList<>();
//        list3.add(6);
//        list3.add(5);
//        list3.add(7);
//        lists.add(list3);
//        ArrayList<Integer> list4 = new ArrayList<>();
//        list4.add(4);
//        list4.add(1);
//        list4.add(8);
//        list4.add(3);
//        lists.add(list4);
        System.out.println(j1120minimumTotal.minimumTotal(lists));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] result = new int[triangle.size()][triangle.size()];
        result[0][0] = triangle.get(0).get(0);
        for (int i=1;i<triangle.size();i++){
            List<Integer> integersRows = triangle.get(i);
            result[i][0] = integersRows.get(0) + result[i-1][0];
            for (int j=1;j<integersRows.size()-1;j++){
                int min = Math.min(result[i-1][j],result[i-1][j-1]);
                result[i][j] = integersRows.get(j) + min;
            }
            result[i][integersRows.size()-1] = integersRows.get(integersRows.size()-1) + result[i-1][integersRows.size()-2];
        }
        OutArrays.outArrays(result);
        int min = result[result.length-1][0];
        for (int i=0;i<result.length;i++){
            min = Math.min(min,result[result.length-1][i]);
        }
        return min;

    }
}
