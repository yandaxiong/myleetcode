package com.xiong.jingdian150_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author xiong
 * @create 2025-11-24-16:47
 */
public class f4_295MedianFinder {

    public static void main(String[] args) {
        f4_295MedianFinder medianFinder = new f4_295MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(-3);
        medianFinder.addNum(-4);
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }

     PriorityQueue<Integer> maxHeap;
     PriorityQueue<Integer> minHeap;
     boolean insertMin = true;

    public f4_295MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)->a-b);
        minHeap = new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        if (minHeap.isEmpty()){
            minHeap.add(num);
            insertMin = false;
            return;
        }
        if(minHeap.peek()>=num){
            minHeap.add(num);
            if(!insertMin) {
                maxHeap.add(minHeap.poll());
            }
        }else {
            maxHeap.add(num);
            if (insertMin){
                minHeap.add(maxHeap.poll());
            }
        }
        insertMin = !insertMin;
        System.out.println(minHeap);
        System.out.println(maxHeap);

    }

    public double findMedian() {
        System.out.println(minHeap);
        System.out.println(maxHeap);
        int maxSize = maxHeap.size();
        int minSize = minHeap.size();
        if(maxSize==0){
            return  minHeap.peek();
        }
        if((maxSize+minSize)%2==0){
            return  ( maxHeap.peek()+minHeap.peek() )/2.0;
        }else {
            return   minHeap.peek();
        }

    }
}
