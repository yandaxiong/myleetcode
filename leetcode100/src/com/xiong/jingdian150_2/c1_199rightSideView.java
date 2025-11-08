package com.xiong.jingdian150_2;

import java.util.*;

/**
 * @author xiong
 * @create 2025-09-08-19:23
 */
public class c1_199rightSideView {
    public static void main(String[] args) {
        c1_199rightSideView c1199rightSideView = new c1_199rightSideView();
        System.out.println(c1199rightSideView.rightSideView(TreeNode.getExampleTreeNode()));

    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        HashMap<TreeNode,Integer> map = new HashMap<>();
        if (root == null) {return result;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root,1);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll);
            Integer i = map.get(poll);
            if (poll.left != null) {
                queue.add(poll.left);
                map.put(poll.left,i+1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                map.put(poll.right,i+1);
            }
        }
        for (int i = 0; i < list.size()-1; i++) {
            TreeNode treeNode = list.get(i);
            TreeNode treeNode1 = list.get(i + 1);
            Integer i1 = map.get(treeNode);
            Integer i2 = map.get(treeNode1);
            if (i1 < i2) {
                result.add(treeNode.val);
            }
        }
        result.add(list.get(list.size()-1).val);
        return result;
    }
}
