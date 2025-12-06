package com.xiong.jingdian150_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiong
 * @create 2025-11-25-20:04
 */
public class h1_70climbStairs {
    public static void main(String[] args) {
        h1_70climbStairs h1_70climbStairs = new h1_70climbStairs();
        System.out.println(h1_70climbStairs.climbStairs(6));
    }

    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(1,1);
        map.put(2,2);
        if (n<=2){
            return map.get(n);
        }
        return climbStairs2(n, map);

    }
    public int climbStairs2(int n,HashMap<Integer, Integer> map ) {
        if (map.containsKey(n)){
            return map.get(n);
        }else {
            int i1 = climbStairs2(n - 1, map);
            int i2 = climbStairs2(n - 2, map);
            map.put(n,i1+i2);
            return i1+i2;
        }
    }
}
