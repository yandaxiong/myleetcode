package com.xiong.top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiong
 * @Description 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @date 2023-02-27 11:11 上午
 */
public class a19_remove_nth_node_from_end_of_list {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode presentNode = head;
        for (int i=2;i<=2;i++){
            ListNode listNode = new ListNode(i);
            presentNode.next = listNode;
            presentNode = listNode;
        }
        System.out.println(head);
        ListNode listNode = removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }
    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode presentNode = head;
        int size = 0;
        while (presentNode!=null){
            size++;
            presentNode = presentNode.next;
        }
        if(size==1){
            return null;
        }
        if(size == n){
            return head.next;
        }

//        1 2 3 4 5    2
        ListNode previousNode = head;
        for (int i = 0; i < size - n - 1; i++) {
            previousNode = previousNode.next;
        }
        previousNode.next = previousNode.next.next;
        return  head;
    }
}
