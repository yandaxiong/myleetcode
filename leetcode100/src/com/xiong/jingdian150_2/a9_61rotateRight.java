package com.xiong.jingdian150_2;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-08-21-20:40
 */
public class a9_61rotateRight {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 1; i < nums1.length; i++) {
            tmp.next = new ListNode(nums1[i]);
            tmp = tmp.next;
        }
        System.out.println(head);
        ListNode listNode = rotateRight(head,4);
        System.out.println(listNode);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null|| k==0) return head;
        ListNode result = new ListNode(0);
        result.next = head;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        k = k % listNodes.size();
        if (k == 0) return result.next;
        listNodes.get(listNodes.size() - k - 1).next = null;
        listNodes.get(listNodes.size()-1).next = result.next;

        return listNodes.get(listNodes.size() - k);

    }
}
