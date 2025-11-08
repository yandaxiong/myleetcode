package com.xiong.jingdian150_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong
 * @create 2025-09-03-20:26
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class b11_124maxPathSum {

    public static void main(String[] args) {
        TreeNode exampleTreeNode = TreeNode.getExampleTreeNode();
        int i = new b11_124maxPathSum().maxPathSum(exampleTreeNode);
        System.out.println(exampleTreeNode);
        System.out.println(i);
    }
    boolean first = true;
    public int maxPathSum(TreeNode root) {
        if (root == null) return -10000;
        if(root.left == null && root.right == null && first){return root.val;}
        first =false;
        int max = maxPathSum1(root.left)+maxPathSum1(root.right)+ root.val;
        System.out.println("left====="+maxPathSum1(root.left));
        System.out.println("right====="+maxPathSum1(root.right));
        System.out.println("max====="+max);
        return Math.max(Math.max(max, maxPathSum(root.left)),maxPathSum(root.right))  ;
    }



//    public int maxPathSum(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        maxPathSumList(root, list);
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < list.size(); i++) {
//            max=Math.max(list.get(i), max);
//        }
//        return max;
//    }
//    public void maxPathSumList(TreeNode root, List<Integer> list){
//        if(root == null) return;
//        if(root.left == null && root.right == null){
//            System.out.println(root.val + "====" +root.val);
//            list.add(root.val);
//        }else if(maxPathSum1(root.left)<=0 && maxPathSum1(root.right)<=0 ){
//            System.out.println(root.val + "====" +root.val);
//            list.add(root.val);
//        }else {
//            int max = maxPathSum1(root.left) + maxPathSum1(root.right) + root.val;
//            list.add(max);
//            System.out.println(root.val + "====" +max);
//        }
//        maxPathSumList(root.left,list);
//        maxPathSumList(root.right,list);
//
//    }
//   找作为根节点最大的数字
    public int maxPathSum1(TreeNode root) {
        if (root == null) return 0;
        int tmp = Math.max(Math.max(maxPathSum1(root.left), maxPathSum1(root.right)),0) + root.val;
        System.out.println("tmp"+tmp);
        return Math.max(tmp,0);
    }


}
