package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-09-03-20:40
 */
public class b13_222countNodes {
    public static void main(String[] args) {

    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
