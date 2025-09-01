package com.xiong.jingdian150_2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiong
 * @create 2025-08-27-21:08
 */
public class b5_105buildTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,1,2,20,15,7};
        int[] inorder = {1,9,2,3,15,20,7};
        TreeNode treeNode = new b5_105buildTree().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = new TreeNode();
        buildTree(preorder,inorder,treeNode,true);
        return treeNode.left;
    }

    public void  buildTree(int[] preorder, int[] inorder, TreeNode root ,Boolean left) {
        if (preorder.length==0) {return;}
        int zhongjian = preorder[0];
        TreeNode treeNode = new TreeNode(zhongjian);
        if(left){
            root.left=treeNode;
        }else {
            root.right=treeNode;
        }
        int leftSize = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==zhongjian){
                leftSize = i;
                break;
            }
        }
        int rightSize = preorder.length-leftSize-1;
        if(leftSize>0){
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftSize+1);
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
            buildTree(leftPreorder,leftInorder,treeNode,true);
        }
        if(rightSize>0){
            int[] rightPreorder = Arrays.copyOfRange(preorder, 1+leftSize, preorder.length);
            int[] rightInorder = Arrays.copyOfRange(inorder, 1+leftSize, preorder.length);
            buildTree(rightPreorder,rightInorder,treeNode,false);
        }





    }






}
