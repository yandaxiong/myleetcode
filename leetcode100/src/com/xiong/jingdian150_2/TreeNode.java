package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-08-22-16:21
 */
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

//    @Override
//    public String toString() {
//        return "TreeNode{" +
//                "val=" + val +
//                ", left=" + left +
//                ", right=" + right +
//                '}';
//    }
@Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
    public static TreeNode getExampleTreeNode(){
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNodeL1 = new TreeNode(2);
        TreeNode treeNodeR1 = new TreeNode(6);
        treeNode.left = treeNodeL1;
        treeNode.right = treeNodeR1;
        TreeNode treeNodeL1L1 = new TreeNode(1);
        TreeNode treeNodeL1R1 = new TreeNode(3);
        treeNodeL1.left = treeNodeL1L1;
        treeNodeL1.right = treeNodeL1R1;
//        TreeNode treeNodeR1L1 = new TreeNode(21);
//        TreeNode treeNodeR1R1 = new TreeNode(22);
//        treeNodeR1.left = treeNodeR1L1;
//        treeNodeR1.right = treeNodeR1R1;




        return  treeNode;
    }

}
