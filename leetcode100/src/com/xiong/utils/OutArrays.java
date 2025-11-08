package com.xiong.utils;

import java.util.Arrays;

/**
 * @author xiong
 * @Description
 * @date 2023-03-07 8:45 下午
 */
public class OutArrays {
    public static  void outArrays(int[][] a){
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("-----------------------------");
    }
    public static  void outArrays(int[] a){
        System.out.println(Arrays.toString(a));
        System.out.println("-----------------------------");
    }
    public static  void outArrays(double[] a){
        System.out.println(Arrays.toString(a));
        System.out.println("-----------------------------");
    }
    public static  void outArrays(char[][] a){
        for (char[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("-----------------------------");
    }
    public static  void outArrays(double[][] a){
        for (double[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("-----------------------------");
    }
}
