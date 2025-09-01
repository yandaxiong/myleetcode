package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-08-27-20:24
 */
public class b3_226invertTree {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        invertTree2(root);
        return root;
    }
    public void invertTree2(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left != null) {
                invertTree2(root.left);
            }
            if (root.right != null) {
                invertTree2(root.right);
            }
        }
    }
}
