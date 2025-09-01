package com.xiong.jingdian150_2;

import java.util.Stack;

/**
 * @author xiong
 * @create 2025-08-21-17:27
 */
public class a6_25reverseKGroup {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 1; i < nums1.length; i++) {
            tmp.next = new ListNode(nums1[i]);
            tmp = tmp.next;
        }
        System.out.println(head);
        ListNode listNode = reverseKGroup(head, 2);
        System.out.println(listNode);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {return head;}
        if(k==1) return head;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode before = result;
        Stack<ListNode> listNodes = new Stack<>();
        int num = 0;
        while (head != null) {
            listNodes.push(head);
            num++;
            head = head.next;
            if (num == k) {
                for (int i=0; i<k; i++) {
                    before.next = listNodes.pop();
                    before = before.next;
                }
                before.next = head;
                num = 0;
            }
        }

        return result.next;
    }
}
