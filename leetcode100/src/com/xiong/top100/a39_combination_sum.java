package com.xiong.top100;

import java.util.*;

/**
 * @author xiong
 * @Description 组合总和
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * @date 2023-03-02 5:18 下午
 */
public class a39_combination_sum {
    public static void main(String[] args) {
        a39_combination_sum a39 = new a39_combination_sum();
        int [] candidates = {2,3,6,7};
        System.out.println(a39.combinationSum(candidates,7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        if(len==0){
            return  resultList;
        }
        LinkedList<Integer> deque = new LinkedList<>();

        huisu(candidates,0,target,len,resultList,deque);
        return resultList;
    }
    public void huisu(int[] candidates,int index,int target,int len,ArrayList<List<Integer>> resultList,LinkedList<Integer> deque) {
        if(target<0){
            return;
        }
        if(target==0){
            System.out.println(deque);
            resultList.add(new LinkedList<>(deque));
        }else {
            for (int i=index;i<len;i++){
                deque.addLast(candidates[i]);
                huisu(candidates,i,target-candidates[i],len,resultList,deque);
                deque.removeLast();
            }
        }
    }


}
