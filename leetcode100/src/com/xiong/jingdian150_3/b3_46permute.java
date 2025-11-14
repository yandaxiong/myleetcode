package com.xiong.jingdian150_3;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong
 * @create 2025-11-14-15:09
 */
public class b3_46permute {
    public static void main(String[] args) {
        b3_46permute b346permute = new b3_46permute();
        System.out.println(b346permute.permute(new int[]{1}));
    }
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        boolean[] booleans = new boolean[nums.length];
        ArrayList<Integer> tmp = new ArrayList<>();
        backtrack(nums,booleans,result,tmp);
        return  result;
    }

    private void backtrack(int[] nums, boolean[] booleans, ArrayList<List<Integer>> result, ArrayList<Integer> tmp) {
        if(tmp.size() == nums.length){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(!booleans[i]){
                int num = nums[i];
                tmp.add(num);
                booleans[i] = true;
                backtrack(nums,booleans,result,tmp);
                tmp.remove(tmp.size()-1);
                booleans[i] = false;
            }
        }
    }


}
