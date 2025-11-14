package com.xiong.jingdian150_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong
 * @create 2025-11-14-13:54
 */
public class b2_77Solution {
    public static void main(String[] args) {
        b2_77Solution b277Solution = new b2_77Solution();
        System.out.println(b277Solution.combine(5,3));
    }

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n+1];
        backtrack(n,k,1,used,result,new ArrayList<>());

        return result;
    }

    public void backtrack(int n,int k,int start,boolean[] used,ArrayList<List<Integer>> result,ArrayList<Integer> tmp){
        if (k == tmp.size()){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n; i++){
            if (!used[i]){
                used[i] = true;
                tmp.add(i);
                backtrack(n,k,start,used,result,tmp);
                tmp.remove(tmp.size()-1);
                used[i] = false;
            }
            start++;
        }
    }
}
