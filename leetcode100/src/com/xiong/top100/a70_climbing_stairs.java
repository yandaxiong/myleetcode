package com.xiong.top100;

import java.util.LinkedList;

/**
 * @author xiong
 * @Description 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @date 2023-03-07 10:26 上午
 */
public class a70_climbing_stairs {
    public static void main(String[] args) {
        a70_climbing_stairs a70_climbing_stairs = new a70_climbing_stairs();
        System.out.println(a70_climbing_stairs.climbStairs2(44));
        System.out.println(a70_climbing_stairs.climbStairs(44));
    }
    public int climbStairs(int n) {
        int[] result = new int[n];
        if(n==1) return 1;
        if(n==2) return 2;
        result[0]=1;
        result[1]=2;
        for (int i=2;i<n;i++){
            result[i]=result[i-1]+result[i-2];
        }
        return  result[n-1];

    }
    public int climbStairs2(int n) {
        Integer climbSum=0;
        return backtrack(n,0,climbSum);
    }
    public int backtrack(int n,int result,Integer climbSum){
        if(climbSum==n){
            return  result+1;
        }
        if(climbSum>n){
            return  result;
        }
        for (int i=1;i<=2;i++){
            climbSum+=i;
            result = backtrack(n,result,climbSum);
            climbSum = climbSum-i;
        }
        return result;
    }

}
