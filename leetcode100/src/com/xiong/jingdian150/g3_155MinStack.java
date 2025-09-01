package com.xiong.jingdian150;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-08-13-20:27
 */
public class g3_155MinStack {
      ArrayList<Integer> integers ;

    public g3_155MinStack() {
        integers = new ArrayList<>();
    }

    public void push(int val) {
        integers.add(val);
    }

    public void pop() {
        integers.remove(integers.size()-1);
    }

    public int top() {
        return integers.get(integers.size()-1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < integers.size(); i++) {
            min = Math.min(min, integers.get(i));
        }
        return min;
    }
}
