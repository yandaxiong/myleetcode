package com.xiong.jingdian150_2;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-08-21-19:58
 */
public class a7_19removeNthFromEnd {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 1; i < nums1.length; i++) {
            tmp.next = new ListNode(nums1[i]);
            tmp = tmp.next;
        }
        System.out.println(head);
        ListNode listNode = removeNthFromEnd(head, 1);
        System.out.println(listNode);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(head.next == null) return null;
        ListNode result = new ListNode(0);
        result.next = head;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            if (listNodes.size() > n) {
                listNodes.remove(0);
            }
            listNodes.add(head);
            head = head.next;
        }
        if (n==1){
            listNodes.get(listNodes.size()-2).next = null;
        } else if (listNodes.size() == n ) {
            result.next = listNodes.get(0).next;
        }else {
            listNodes.get(0).next = listNodes.get(listNodes.size()-n).next;
        }

        return result.next;

    }
}
