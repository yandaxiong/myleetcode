package com.xiong.jingdian150;

import java.lang.invoke.VarHandle;
import java.util.*;

/**
 * @author xiong
 * @create 2025-07-24-20:09
 * 实现RandomizedSet 类：
 */
public class a93_380RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random ;

    public a93_380RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val,list.size());
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        list.set(index, list.get(list.size()-1));
        map.put(list.get(index),index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
