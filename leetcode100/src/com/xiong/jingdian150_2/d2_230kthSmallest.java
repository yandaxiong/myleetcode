package com.xiong.jingdian150_2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiong
 * @create 2025-09-09-20:26
 */
public class d2_230kthSmallest {
    public static void main(String[] args) {
        d2_230kthSmallest d2230kthSmallest = new d2_230kthSmallest();
        d2230kthSmallest.kthSmallest(TreeNode.getExampleTreeNode(),5);
    }
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> s = new LinkedList<>();
        int index = 0;
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                index++;
                if (index == k)
                    return root.val;
                root = root.right;
            }
            System.out.println(s);
        }
        return 0;
    }


}
