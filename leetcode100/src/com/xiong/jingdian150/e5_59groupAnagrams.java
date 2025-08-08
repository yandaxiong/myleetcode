package com.xiong.jingdian150;

import java.util.*;

/**
 * @author xiong
 * @create 2025-08-07-21:17
 */
public class e5_59groupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> lists = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            if (map.containsKey(String.valueOf(charArray))) {
                map.get(String.valueOf(charArray)).add(str);
            }else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(String.valueOf(charArray), list);
            }

        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }
        return lists;
    }
}
