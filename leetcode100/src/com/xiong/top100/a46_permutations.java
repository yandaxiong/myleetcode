package com.xiong.top100;

import java.util.*;

/**
 * @author xiong
 * @Description
 * @date 2023-03-03 3:17 下午
 */
public class a46_permutations {
    public static void main(String[] args) {
        a46_permutations a46 = new a46_permutations();
        int[] a = {1,2,3};
        System.out.println(a46.permute(a));
    }
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        int length = nums.length;
        ArrayList<Integer> outputList = new ArrayList<>(length);
        for (int num:nums){
            outputList.add(num);
        }
        backtrack(outputList,0,length,resultList);
        return  resultList;
    }
    public void backtrack(ArrayList<Integer> outputList,int index,int len,ArrayList<List<Integer>> resultList){
        if(index == len){
            resultList.add(new ArrayList<>(outputList));
        }else {
            for (int i=index;i<len;i++){
                Collections.swap(outputList,index,i);
                backtrack(outputList,index+1,len,resultList);
                Collections.swap(outputList,index,i);
            }

        }
    }
}
