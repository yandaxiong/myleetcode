package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author xiong
 * @create 2025-11-21-16:55
 */
public class f2_502findMaximizedCapital {
    public static void main(String[] args) {
        f2_502findMaximizedCapital f2_502findMaximizedCapital = new f2_502findMaximizedCapital();
        int[] profits = new int[]{1,2,3};
        int[] capital = new int[]{0,1,1};
        System.out.println(f2_502findMaximizedCapital.findMaximizedCapital(2,1,profits,capital));
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a,b)->a[0]-b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;


    }
}
