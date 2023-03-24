package com.xiong.top100;

/**
 * @author xiong
 * @Description 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * @date 2023-03-16 4:27 下午
 */
public class a96_unique_binary_search_trees {
    public static void main(String[] args) {
        a96_unique_binary_search_trees a96UniqueBinarySearchTrees = new a96_unique_binary_search_trees();
        System.out.println(a96UniqueBinarySearchTrees.numTrees(4));
    }
    public int numTrees(int n) {
        int[] result = new int[n];
        result[0] = 1;
        for (int i=1;i<n;i++){
            int num = 0;
            for (int j=0;j<=i;j++){
                int leftNum = 1;
                int rightNum = 1;
                if(j-1>=0){
                    leftNum = result[j-1];
                }
                if(i-j>0){
                    rightNum = result[i-j-1];
                }
                num = num + leftNum*rightNum;
            }
            result[i]=num;
        }
        return  result[n-1];

    }
}
