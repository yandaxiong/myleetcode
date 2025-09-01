package com.xiong.jingdian150_2;

import java.awt.image.renderable.RenderableImage;
import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-08-27-20:35
 */
public class b4_101isSymmetric {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNodeL1 = new TreeNode(2);
        TreeNode treeNodeR1 = new TreeNode(2);
        treeNode.left = treeNodeL1;
        treeNode.right = treeNodeR1;
        TreeNode treeNodeL1L1 = new TreeNode(3);
        TreeNode treeNodeL1R1 = new TreeNode(4);
        treeNodeL1.left = treeNodeL1L1;
        treeNodeL1.right = treeNodeL1R1;
        TreeNode treeNodeR1L1 = new TreeNode(4);
        TreeNode treeNodeR1R1 = new TreeNode(3);
        treeNodeR1.left = treeNodeR1L1;
        treeNodeR1.right = treeNodeR1R1;
        ArrayList<Integer> objects = new ArrayList<>();
        b4_101isSymmetric b4101isSymmetric = new b4_101isSymmetric();
        System.out.println(b4101isSymmetric.isSymmetric(treeNode));
    }
    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> objects = new ArrayList<>();
        right(root.right, objects);
        ArrayList<Integer> objects2 = new ArrayList<>();
        left(root.left, objects2);

        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) != objects2.get(i)) {
                return false;
            }
        }
        return true;
    }
    public  void right(TreeNode root, ArrayList<Integer> list) {
        if(root == null) {
            list.add(null) ;
            return;
        }
        list.add(root.val);
        right(root.right,list);
        right(root.left,list);
    }
    public  void left(TreeNode root, ArrayList<Integer> list){
        if(root == null) {
            list.add(null) ;
            return;
        }
        list.add(root.val);
        left(root.left,list);
        left(root.right,list);
    }

}
