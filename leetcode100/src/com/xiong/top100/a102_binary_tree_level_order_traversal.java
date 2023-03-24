package com.xiong.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiong
 * @Description . 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 * @date 2023-03-16 5:47 下午
 */
public class a102_binary_tree_level_order_traversal {
    public static void main(String[] args) {
        a102_binary_tree_level_order_traversal a102BinaryTreeLevelOrderTraversal = new a102_binary_tree_level_order_traversal();
        System.out.println(a102BinaryTreeLevelOrderTraversal.levelOrder(TreeNode.getExampleTreeNode()));

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        if (root==null){
            return  resultList;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (treeNodes.size()>0){
            ArrayList<Integer> list = new ArrayList<>();
            for (TreeNode treeNode:treeNodes){
                list.add(treeNode.val);
            }
            resultList.add(list);
            int size = treeNodes.size();
            for (int i=0;i<size;i++){
                TreeNode treeNode = treeNodes.getFirst();
                if(treeNode.left!=null){
                    treeNodes.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    treeNodes.add(treeNode.right);
                }
                treeNodes.removeFirst();
            }
        }
        return  resultList;
    }
}
