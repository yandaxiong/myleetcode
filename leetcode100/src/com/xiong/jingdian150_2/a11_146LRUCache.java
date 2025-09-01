package com.xiong.jingdian150_2;

import java.lang.invoke.VarHandle;
import java.security.Key;
import java.util.*;

/**
 * @author xiong
 * @create 2025-08-21-21:26
 */
public class a11_146LRUCache {
    LinkedHashMap<Integer, Integer> result;
    int capacity;

    public a11_146LRUCache(int capacity) {
        result = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;

    }

    public int get(int key) {
        Integer i = result.get(key);
        if (i == null) {
            return -1;
        }
        return i;
    }

    public void put(int key, int value) {
        result.put(key,value);
        if(result.size()== capacity+1){
            Integer firstKey = result.keySet().iterator().next();
            result.remove(firstKey);
        }

    }

    public static void main(String[] args) {
        a11_146LRUCache lRUCache = new a11_146LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);
    }


}
