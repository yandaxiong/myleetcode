package com.xiong.jingdian150_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiong
 * @create 2025-11-13-10:38
 */
public class f2_433minMutation {
    public static void main(String[] args) {
        f2_433minMutation f2433minMutation = new f2_433minMutation();
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(f2433minMutation.minMutation(start, end, bank));
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)) return 0;
        boolean[] visited = new boolean[bank.length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{100,0});
        while (!queue.isEmpty()){
            int[] oriInt = queue.poll();
            String oriStr ;
            if(oriInt[0] == 100){
                 oriStr = startGene;
            }else {
                 oriStr = bank[oriInt[0]];
            }
            for (int i=0;i<bank.length;i++){
                String tarStr = bank[i];
                if (!visited[i] && isValid(oriStr,tarStr)){
                    if (tarStr.equals(endGene)){
                        return oriInt[1]+1;
                    }
                    queue.offer(new int[]{i,oriInt[1]+1});
                    visited[i] = true;
                }

            }
        }
        return -1;
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
