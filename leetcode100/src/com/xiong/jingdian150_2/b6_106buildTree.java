package com.xiong.jingdian150_2;

import java.util.Arrays;

/**
 * @author xiong
 * @create 2025-08-28-21:00
 */
public class b6_106buildTree {
    public static void main(String[] args) {
        int[] inorder  = {9,3,15,20,7};
        int[] postorder  = {9,15,7,20,3};
        TreeNode treeNode = new b6_106buildTree().buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode treeNode = new TreeNode();
        buildTree(inorder,postorder,treeNode,true);
        return treeNode.left;
    }

    public void  buildTree(int[] inorder, int[] postorder, TreeNode root ,Boolean left) {
        int length = postorder.length;
        if (length == 0) {
            return;
        }
        int zhongjian = postorder[length-1];
        TreeNode treeNode = new TreeNode(zhongjian);
        if (left) {
            root.left = treeNode;
        } else {
            root.right = treeNode;
        }
        int leftSize = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == zhongjian) {
                leftSize = i;
                break;
            }
        }
        int rightSize = postorder.length - leftSize - 1;
        if (leftSize > 0) {
            int[] leftPreorder = Arrays.copyOfRange(postorder, 0, leftSize);
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
            buildTree(leftInorder,leftPreorder, treeNode, true);
        }
        if (rightSize > 0) {
            int[] rightPreorder = Arrays.copyOfRange(postorder, leftSize, length-1);
            int[] rightInorder = Arrays.copyOfRange(inorder, 1 + leftSize, length);
            buildTree(rightInorder,rightPreorder,  treeNode, false);
        }
    }
}
