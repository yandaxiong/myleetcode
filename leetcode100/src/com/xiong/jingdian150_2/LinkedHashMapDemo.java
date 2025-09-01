package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-08-22-16:12
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // 1. 插入顺序模式（默认）
        System.out.println("=== 插入顺序模式 ===");
        LinkedHashMap<String, Integer> insertOrderMap = new LinkedHashMap<>();
        insertOrderMap.put("apple", 1);
        insertOrderMap.put("banana", 2);
        insertOrderMap.put("cherry", 3);

        // 迭代顺序与插入顺序一致
        for (Map.Entry<String, Integer> entry : insertOrderMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 访问元素不会改变顺序
        insertOrderMap.get("banana");
        System.out.println("\n访问banana后顺序不变：");
        for (Map.Entry<String, Integer> entry : insertOrderMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 2. 访问顺序模式（适合LRU缓存）
        System.out.println("\n=== 访问顺序模式 ===");
        LinkedHashMap<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put("apple", 1);
        accessOrderMap.put("banana", 2);
        accessOrderMap.put("cherry", 3);

        // 访问元素会将其移到链表末尾
        accessOrderMap.get("banana");  // 访问banana
        accessOrderMap.get("apple");   // 访问apple
        accessOrderMap.put("cherry", 4);

        System.out.println("访问后顺序（最近访问的在末尾）：");
        for (Map.Entry<String, Integer> entry : accessOrderMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 3. 实现简单的LRU缓存（重写removeEldestEntry方法）
        System.out.println("\n=== LRU缓存示例 ===");
        LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<>(3, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                // 当条目数超过3时，自动移除最久未访问的条目
                return size() > 3;
            }
        };

        lruCache.put("a", 1);
        lruCache.put("b", 2);
        lruCache.put("c", 3);
        System.out.println("添加3个元素后：" + lruCache.keySet());

        lruCache.get("a");  // 访问a，使其成为最近访问
        lruCache.put("d", 4);  // 添加第4个元素，触发移除最久未访问的b
        System.out.println("添加d后（移除最久未访问的b）：" + lruCache.keySet());
    }
}

