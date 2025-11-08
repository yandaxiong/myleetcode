package com.xiong.jingdian150_2;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-09-01-17:53
 */
public class b8_114flatten {
    public static void main(String[] args) {

    }
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        xianxu(root, treeNodes);
        for(int i=1; i<treeNodes.size(); i++){
            root.left =null;
            root.right = treeNodes.get(i);
            if(i<treeNodes.size()-1){
                root = treeNodes.get(i);
            }
        }

    }
    public void xianxu(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        xianxu(root.left, list);
        xianxu(root.right, list);
    }



}
