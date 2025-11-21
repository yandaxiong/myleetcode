package com.xiong.jingdian150_3;

import com.xiong.jingdian150_2.TreeNode;

/**
 * @author xiong
 * @create 2025-11-18-11:13
 */
public class c1_108TreeNode {
    public static void main(String[] args) {
        c1_108TreeNode c1_108TreeNode = new c1_108TreeNode();
        TreeNode treeNode = c1_108TreeNode.sortedArrayToBST(new int[]{0,1,2,3,4,5});
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }



}
