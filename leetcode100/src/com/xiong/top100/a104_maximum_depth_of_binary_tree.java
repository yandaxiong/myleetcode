package com.xiong.top100;

/**
 * @author xiong
 * @Description 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @date 2023-03-17 4:45 下午
 */
public class a104_maximum_depth_of_binary_tree {
    public static void main(String[] args) {
        a104_maximum_depth_of_binary_tree test = new a104_maximum_depth_of_binary_tree();
        System.out.println(test.maxDepth(TreeNode.getExampleTreeNode()));
    }
    public int maxDepth(TreeNode root) {
        return getDepth(root, 0);
    }
    public int getDepth(TreeNode root,int depth){
        if(root==null){
            return depth;
        }
        depth = depth + 1;
        int depthLeft = getDepth(root.left, depth);
        int depthRight = getDepth(root.right, depth);
        return Math.max(Math.max(depth, depthLeft), depthRight);
    }

}
