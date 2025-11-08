package com.xiong.jingdian150_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiong
 * @create 2025-09-09-20:02
 */
public class c2_637averageOfLevels {
    public static void main(String[] args) {

    }
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        ArrayList<Double> doubles = new ArrayList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodes.poll();
                sum += treeNode.val;
                if (treeNode.left != null) {
                    treeNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.add(treeNode.right);
                }
            }
            doubles.add(sum / size);
        }
        return doubles;


    }
}
