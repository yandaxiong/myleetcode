package com.xiong.jingdian150_2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author xiong
 * @create 2025-08-14-20:03
 */
public class a2_2addTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 1; i < nums1.length; i++) {
            tmp.next = new ListNode(nums1[i]);
            tmp = tmp.next;
        }

        int[] nums2 = {1,9,9,9,9,9,9,9,9,9};
        ListNode head2 = new ListNode(1);
        ListNode tmp2 = head2;
        for (int i = 1; i < nums2.length; i++) {
            tmp2.next = new ListNode(nums2[i]);
            tmp2 = tmp2.next;
        }

        addTwoNumbers(head, head2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            listNode.next = new ListNode(sum);
            listNode = listNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            listNode.next = new ListNode(carry);

        }
        return head.next;
    }
}
