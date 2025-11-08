package com.xiong.jingdian150_2;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author xiong
 * @create 2025-09-03-20:26
 */
public class b12_173BSTIterator {
    ArrayDeque<TreeNode> stack;
    public b12_173BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        zhongxu(root,stack);
    }
    private void zhongxu(TreeNode root,ArrayDeque<TreeNode> stacktmp){
        if(root == null){return;}
        zhongxu(root.left,stacktmp);
        stack.push(root);
        zhongxu(root.right,stacktmp);
    }

    public int next() {
        return stack.removeLast().val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
