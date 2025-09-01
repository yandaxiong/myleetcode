package com.xiong.jingdian150_2;

import java.util.ArrayList;

/**
 * @author xiong
 * @create 2025-08-21-20:59
 */
public class a10_86partition {
    public static void main(String[] args) {
        int[] nums1 = {4,3,2,5,2};
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        for (int i = 0; i < nums1.length; i++) {
            tmp.next = new ListNode(nums1[i]);
            tmp = tmp.next;
        }
        head= head.next;
        System.out.println(head);
        ListNode listNode = partition(head,3);
        System.out.println(listNode);
    }
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null || x<-100 ) return head;
        ArrayList<ListNode> minList = new ArrayList<>();
        ArrayList<ListNode> maxList = new ArrayList<>();
        while (head != null) {
            if (head.val < x) {
                if (!minList.isEmpty()){
                    minList.get(minList.size()-1).next = head;
                }
                minList.add(head);
            }
            if (head.val >= x) {
                if (!maxList.isEmpty()){
                    maxList.get(maxList.size()-1).next = head;
                }
                maxList.add(head);
            }
            head = head.next;
        }
        System.out.println(maxList);
        if (minList.isEmpty()) return maxList.get(0);
        if (maxList.isEmpty()){
            return minList.get(0);
        }
        minList.get(minList.size() - 1).next =maxList.get(0);
        maxList.get(maxList.size() - 1).next = null;
        return minList.get(0);

    }
}
