package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-08-28-21:07
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }

    public String toString2() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
