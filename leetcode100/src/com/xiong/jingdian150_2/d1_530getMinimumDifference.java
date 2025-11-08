package com.xiong.jingdian150_2;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-09-09-20:15
 */
public class d1_530getMinimumDifference {
    public static void main(String[] args) {

    }
    public int getMinimumDifference(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        if(root == null) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        getMinimumDifference2(root,list);
        for(int i = 0; i < list.size()-1; i++){
            minDiff = Math.min(minDiff,Math.abs(list.get(i)-list.get(i+1)));
        }
        return minDiff;
    }
    public void getMinimumDifference2(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;
        getMinimumDifference2(root.left, list);
        list.add(root.val);
        getMinimumDifference2(root.right, list);
    }


}
