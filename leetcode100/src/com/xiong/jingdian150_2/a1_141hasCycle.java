package com.xiong.jingdian150_2;


import java.util.HashMap;
import java.util.HashSet;
import java.util.HexFormat;

/**
 * @author xiong
 * @create 2025-08-14-14:11
 */
public class a1_141hasCycle {

    public static void main(String[] args) {

    }
    public  boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {return false;}
        HashSet<ListNode> listNodes = new HashSet<>();
        listNodes.add(head);
        while (head.next != null) {
            if (listNodes.contains(head.next)) {
                return true;
            }
            listNodes.add(head.next);
            head = head.next;
        }
        return false;
    }
}
