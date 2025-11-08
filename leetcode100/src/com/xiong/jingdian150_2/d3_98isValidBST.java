package com.xiong.jingdian150_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiong
 * @create 2025-09-09-20:52
 */
public class d3_98isValidBST {
    public static void main(String[] args) {

    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

}
