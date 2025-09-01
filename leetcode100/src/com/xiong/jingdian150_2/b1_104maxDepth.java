package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-08-22-16:22
 */
public class b1_104maxDepth {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNodeL1 = new TreeNode(9);
        TreeNode treeNodeR1 = new TreeNode(20);
        treeNode.left = treeNodeL1;
        treeNode.right = treeNodeR1;
//        TreeNode treeNodeL1L1 = new TreeNode(21);
//        TreeNode treeNodeL1R1 = new TreeNode(22);
//        treeNodeL1.left = treeNodeL1L1;
//        treeNodeL1.right = treeNodeL1R1;
        TreeNode treeNodeR1L1 = new TreeNode(15);
        TreeNode treeNodeR1R1 = new TreeNode(7);
        treeNodeR1.left = treeNodeR1L1;
        treeNodeR1.right = treeNodeR1R1;
        System.out.println(maxDepth(treeNode));
    }
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
