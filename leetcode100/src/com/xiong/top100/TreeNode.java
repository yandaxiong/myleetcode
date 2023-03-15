package com.xiong.top100;

/**
 * @author xiong
 * @Description
 * @date 2023-03-15 5:35 下午
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode getExampleTreeNode(){
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNodeL1 = new TreeNode(2);
        TreeNode treeNodeR1 = new TreeNode(3);
        treeNode.left = treeNodeL1;
        treeNode.right = treeNodeR1;
        TreeNode treeNodeL1L1 = new TreeNode(21);
        TreeNode treeNodeL1R1 = new TreeNode(22);
        treeNodeL1.left = treeNodeL1L1;
        treeNodeL1.right = treeNodeL1R1;
        TreeNode treeNodeR1L1 = new TreeNode(31);
        TreeNode treeNodeR1R1 = new TreeNode(32);
        treeNodeR1.left = treeNodeR1L1;
        treeNodeR1.right = treeNodeR1R1;
        return  treeNode;
    }

}
