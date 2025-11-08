package com.xiong.jingdian150_2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiong
 * @create 2025-09-09-20:09
 */
public class c4_103zigzagLevelOrder {
    public static void main(String[] args) {

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {return result;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        for (int i=1; i<result.size(); i=i+2) {
            List<Integer> integers = result.get(i);
            List<Integer> list = new ArrayList<>();
            for (int j=integers.size()-1; j>=0; j--) {
                list.add(integers.get(j));
            }
            result.set(i, list);
        }

        return result;
    }
}
