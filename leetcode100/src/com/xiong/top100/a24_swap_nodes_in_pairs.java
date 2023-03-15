package com.xiong.top100;

/**
 * @author xiong
 * @Description 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 * @date 2023-02-27 9:19 下午
 */
public class a24_swap_nodes_in_pairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode presentNode = head;
        for (int i=2;i<=2;i++){
            ListNode listNode = new ListNode(i);
            presentNode.next = listNode;
            presentNode = listNode;
        }
        System.out.println(head);
        ListNode listNode = swapPairs(head);
        System.out.println(listNode);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null){
            return  head;
        }
        ListNode resultNode = new ListNode();
        resultNode.next= head;
        ListNode previousNode = resultNode;
        while (previousNode.next!=null && previousNode.next.next!=null){
            ListNode aNode = previousNode.next;
            ListNode bNode = previousNode.next.next;
            previousNode.next = bNode;
            ListNode cNode = bNode.next;
            bNode.next = aNode;
            aNode.next = cNode;
            previousNode = aNode;
        }
        return  resultNode.next;
    }
}
