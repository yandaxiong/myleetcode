package com.xiong.jingdian150_2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author xiong
 * @create 2025-08-20-21:00
 */
public class a5_92reverseBetween {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 1; i < nums1.length; i++) {
            tmp.next = new ListNode(nums1[i]);
            tmp = tmp.next;
        }
        System.out.println(head);
        ListNode listNode = reverseBetween(head, 2, 4);
        System.out.println(listNode);
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<ListNode> listNodes = new Stack<>();
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode hou = null;
        for (int i = 1; i <= right; i++) {
            if (i >= left) {
                listNodes.push(head);
            }
            if(i==right){
                hou = head.next;
            }
            head = head.next;
        }
        ListNode result2 = new ListNode(0);
        result2.next = result;
        for (int i = 0; i < right; i++) {
            if (i >= left-1) {
                result.next = listNodes.pop();
            }
            if(i==right-1){
                result.next.next = hou;
            }
            result = result.next;
        }
        return result2.next.next;
    }

}
