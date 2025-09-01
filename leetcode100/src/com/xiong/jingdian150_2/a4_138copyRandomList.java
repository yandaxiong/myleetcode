package com.xiong.jingdian150_2;

import java.util.HashMap;

/**
 * @author xiong
 * @create 2025-08-20-20:24
 */
public class a4_138copyRandomList {
    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
        if (head == null) {return null;}
        Node newHead = head;
        HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();
        Node first = new Node(0);
        Node node = null;
        while (head != null) {
            if (node == null) {
                node = new Node(head.val);
            }else {
                node.next = new Node(head.val);
                node = node.next;
            }
            nodeNodeHashMap.put(head, node);
            if (first.next == null) {
                first.next = node;
            }
            head = head.next;
        }
        Node newfirst = first.next;
        while (newHead != null) {
            if (newHead.random != null) {
                newfirst.random = nodeNodeHashMap.get(newHead.random);
            }
            newfirst = newfirst.next;
            newHead = newHead.next;
        }
        return first.next;


    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
