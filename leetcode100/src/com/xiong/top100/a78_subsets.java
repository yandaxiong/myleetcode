package com.xiong.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong
 * @Description 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @date 2023-03-07 9:36 下午
 */
public class a78_subsets {
    public static void main(String[] args) {
        a78_subsets a78Subsets = new a78_subsets();
        int[] nums = {1,2,3};
        a78Subsets.subsets(nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        System.out.println(tmp);
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }

    }

}
