package com.xiong.top100;

/**
 * @author xiong
 * @Description  对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称
 * @date 2023-03-16 5:24 下午
 */
public class a101_symmetric_tree {
    public static void main(String[] args) {
        a101_symmetric_tree a101SymmetricTree = new a101_symmetric_tree();

    }
    public boolean isSymmetric(TreeNode root) {
        return  check(root.left, root.right);
    }
    public  boolean check(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null){
            return  false;
        }
        return node1.val==node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
    }
}
