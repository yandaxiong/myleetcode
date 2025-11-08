package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-09-02-20:40
 */
public class b9_112hasPathSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val=1;
        boolean b = new b9_112hasPathSum().hasPathSum(treeNode, 1);
        System.out.println(b);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }



}
