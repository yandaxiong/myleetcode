package com.xiong.top100;

import java.util.ArrayList;

/**
 * @author xiong
 * @Description 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @date 2023-03-16 5:14 下午
 */
public class a98_validate_binary_search_tree {
    public static void main(String[] args) {
        a98_validate_binary_search_tree a98ValidateBinarySearchTree = new a98_validate_binary_search_tree();

    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();
        traversal(root,resultList);
        System.out.println(resultList);
        for (int i=1;i<resultList.size();i++){
            Integer left = resultList.get(i - 1);
            Integer right = resultList.get(i);
            if(left>=right){
                return false;
            }
        }
        return true;
    }
    public void  traversal(TreeNode root, ArrayList<Integer> resultList){
        if (root == null) { return; }
        traversal(root.left,resultList);
        resultList.add(root.val);
        traversal(root.right,resultList);
    }
}
