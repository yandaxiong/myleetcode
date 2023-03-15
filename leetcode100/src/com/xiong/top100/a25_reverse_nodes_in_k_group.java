package com.xiong.top100;

import java.util.LinkedList;

/**
 * @author xiong
 * @Description K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @date 2023-02-28 4:51 下午
 */
public class a25_reverse_nodes_in_k_group {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode presentNode = head;
        for (int i=2;i<=5;i++){
            ListNode listNode = new ListNode(i);
            presentNode.next = listNode;
            presentNode = listNode;
        }
        System.out.println(head);
        ListNode listNode = reverseKGroup(head,2);
        System.out.println(listNode);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode resultNode = new ListNode();
        resultNode.next = head;
        ListNode previousNode = resultNode;
        ListNode presentNode = head;
        LinkedList<ListNode> listNodes = new LinkedList<>();
        while (presentNode!=null){
            listNodes.add(presentNode);
            presentNode = presentNode.next;
            if(listNodes.size()==k){
                for (int j=k-1;j>=0;j--){
                    previousNode.next = listNodes.get(j);
                    previousNode = listNodes.get(j);
                }
                previousNode.next = presentNode;
                listNodes.clear();
            }
        }
        return  resultNode.next;

    }

}
