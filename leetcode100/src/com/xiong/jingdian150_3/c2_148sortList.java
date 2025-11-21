package com.xiong.jingdian150_3;

/**
 * @author xiong
 * @create 2025-11-18-17:33
 */
public class c2_148sortList {
    public static void main(String[] args) {
        c2_148sortList c2_148sortList = new c2_148sortList();
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(0);
//        ListNode listNode11 = new ListNode(1);
//        ListNode listNode12 = new ListNode(2);
//        ListNode listNode13 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        listNode5.next = listNode11;
//        listNode11.next = listNode12;
//        listNode12.next = listNode13;

        ListNode listNode = c2_148sortList.sortList(listNode1);
        System.out.println(listNode);

    }

    public ListNode sortList(ListNode head) {

        int length = 0;
        ListNode firstNode = new ListNode();
        firstNode.next = head;
        while (head != null) {
            head = head.next;
            length++;
        }
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = firstNode, curr = firstNode.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                if (curr != null) {
                    for (int i = 1; i < subLength && curr.next != null; i++) {
                        curr = curr.next;
                    }
                }
                if (curr != null) {
                    ListNode next = curr.next;
                    curr.next = null;
                    curr = next;
                }

                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }
        return firstNode.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode listNode = new ListNode(0);
        ListNode curNode = listNode;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                curNode.next = head1;
                head1 = head1.next;
            } else {
                curNode.next = head2;
                head2 = head2.next;
            }
            curNode = curNode.next;
        }
        if (head1 != null) {
            curNode.next = head1;
        }
        if (head2 != null) {
            curNode.next = head2;
        }
        return listNode.next;
    }


}
