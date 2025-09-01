package com.xiong.jingdian150;

import com.xiong.utils.OutArrays;

import java.util.*;

/**
 * @author xiong
 * @create 2025-08-13-16:13
 */
public class f4_452findMinArrowShots {
    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        ArrayList<int[]> ints = new ArrayList<>();
        for (int[] point : points) {
            ints.add(new int[]{point[0], point[1]});
        }
        ints.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int result = 1;
        int l = ints.get(0)[0];
        int r = ints.get(0)[1];
        for ( int i=1; i < ints.size();i++){
            int l1 = ints.get(i)[0];
            int r1 = ints.get(i)[1];
            if(l1>r){
                result++;
                l = l1;
                r = r1;
            }else{
                l = Math.max(l,l1);
                r = Math.min(r,r1);
            }
        }
        return result;
    }
}
