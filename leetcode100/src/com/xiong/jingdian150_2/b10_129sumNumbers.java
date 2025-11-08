package com.xiong.jingdian150_2;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-09-03-10:48
 */
public class b10_129sumNumbers {
    public static void main(String[] args) {
        TreeNode exampleTreeNode = TreeNode.getExampleTreeNode();
        System.out.println(exampleTreeNode);
        System.out.println(new b10_129sumNumbers().sumNumbers(exampleTreeNode));
    }
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        sumNumbers2(root,0,integers);
        int tmp = 0 ;
        for(Integer integer : integers) {
            tmp += integer;
        }
        return tmp;
    }
    public void sumNumbers2(TreeNode root, int tmpNum,ArrayList<Integer> nums) {
        if (root == null) {return;}
        if (root.left == null && root.right == null) {
            nums.add(tmpNum*10+root.val);
        }
        sumNumbers2(root.left,tmpNum*10+root.val,nums);
        sumNumbers2(root.right,tmpNum*10+root.val,nums);
    }
}
