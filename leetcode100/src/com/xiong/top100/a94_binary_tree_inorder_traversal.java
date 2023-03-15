package com.xiong.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong
 * @Description
 * @date 2023-03-15 5:36 下午
 */
public class a94_binary_tree_inorder_traversal {
    public static void main(String[] args) {
        a94_binary_tree_inorder_traversal a94BinaryTreeInorderTraversal = new a94_binary_tree_inorder_traversal();
        TreeNode exampleTreeNode = TreeNode.getExampleTreeNode();
        System.out.println(a94BinaryTreeInorderTraversal.inorderTraversal(exampleTreeNode));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();
        traversal(root,resultList);
        return  resultList;
    }
    public void  traversal(TreeNode root,ArrayList<Integer> resultList){
        if (root == null) { return; }
        traversal(root.left,resultList);
        resultList.add(root.val);
        traversal(root.right,resultList);
    }
}
