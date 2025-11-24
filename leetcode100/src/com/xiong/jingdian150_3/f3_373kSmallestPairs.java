package com.xiong.jingdian150_3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class f3_373kSmallestPairs {
    public static void main(String[] args) {
        int[] a = {1,7,11};
        int[] b = {2,4,6};
        int k = 3;

        List<List<Integer>> list = new f3_373kSmallestPairs().kSmallestPairs(a, b, k);
        for (List<Integer> list1 : list) {
            System.out.println(list1);
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]);
        int m = nums1.length;
        for (int i=0;i<Math.min(m,k);i++){
            priorityQueue.add(new int[]{i,0});
        }
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        for (int i=0;i<k;i++){
            int[] poll = priorityQueue.poll();
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(nums1[poll[0]]);
            integers.add(nums2[poll[1]]);
            resultList.add( integers);
            if(poll[1]<nums2.length-1){
                priorityQueue.add(new int[]{poll[0],poll[1]+1});
            }
        }
        return  resultList;
    }

}
