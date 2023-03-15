package com.xiong.top100;

import java.util.*;

/**
 * @author xiong
 * @Description 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * @date 2023-03-06 5:24 下午
 */
public class a49_group_anagrams {
    public static void main(String[] args) {
        a49_group_anagrams a48 = new a49_group_anagrams();
        String[] strs = {"eat","tea", "tan", "ate", "nat", "bat"};
        System.out.println(a48.groupAnagrams(strs));

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
