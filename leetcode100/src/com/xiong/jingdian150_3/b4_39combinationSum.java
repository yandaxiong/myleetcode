package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiong
 * @create 2025-11-14-15:16
 */
public class b4_39combinationSum {
    public static void main(String[] args) {
        b4_39combinationSum b439combinationSum = new b4_39combinationSum();
        System.out.println(b439combinationSum.combinationSum(new int[]{8,2,3,6,7},7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,0,target,result,0,tmpList);

        return result;

    }
    private void backtrack(int[] candidates, int start, int target, ArrayList<List<Integer>> result, int tmp,List<Integer> tmpList ) {
        if(tmp == target){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        if(tmp > target){
            return;
        }
        for (int i=start;i<candidates.length;i++){
            int candidate = candidates[i];
            tmpList.add(candidate);
            backtrack(candidates,start,target,result,tmp + candidate,tmpList);
            tmpList.remove(tmpList.size()-1);
            start++;
        }
    }
}
