package com.xiong.jingdian150_2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiong
 * @create 2025-11-13-11:11
 */
public class f3_127ladderLength {
    public static void main(String[] args) {
        f3_127ladderLength f3127ladderLength = new f3_127ladderLength();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log"};
        List<String> list = List.of(wordList);
        System.out.println(f3127ladderLength.ladderLength(beginWord, endWord, list));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        boolean[] visited = new boolean[wordList.size()];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{10000,1});
        while (!queue.isEmpty()){
            int[] oriInt = queue.poll();
            String oriStr ;
            if(oriInt[0] == 10000){
                oriStr = beginWord;
            }else {
                oriStr = wordList.get(oriInt[0]);
            }
            for (int i=0;i<wordList.size();i++){
                String tarStr = wordList.get(i);
                if (!visited[i] && isValid(oriStr,tarStr)){
                    if (tarStr.equals(endWord)){
                        return oriInt[1]+1;
                    }
                    queue.offer(new int[]{i,oriInt[1]+1});
                    visited[i] = true;
                }

            }
        }
        return 0;
    }
    public boolean isValid(String oriStr,String tarStr) {
        int i = 0;
        for (int j = 0; j < tarStr.length(); j++){
            if (oriStr.charAt(j) != tarStr.charAt(j)){
                i++;
            }
        }
        return i == 1;
    }
}
