package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-08-21-20:17
 */
public class a8_82deleteDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {1,1};
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 1; i < nums1.length; i++) {
            tmp.next = new ListNode(nums1[i]);
            tmp = tmp.next;
        }
        System.out.println(head);
        ListNode listNode = deleteDuplicates(head);
        System.out.println(listNode);
    }
    public static ListNode deleteDuplicates(ListNode head) {
//       200 ,1,2,3
        if (head == null || head.next == null) {return head;}
        ListNode result = new ListNode(200);
        result.next = head;
        boolean delete = false;
        ListNode pre1 = result;
        ListNode pre2 = head;
        int val = head.val;
        head = head.next;
        while (head != null) {
            if(val != head.val){
               if(delete){
                   pre2 = head;
                   pre1.next = head;
               }else{
                   pre1 = pre2;
                   pre2 = head;
               }
                val = head.val;
               delete = false;
            }else{
                delete = true;
            }
            head = head.next;
        }
        if(delete){
            pre1.next = head;
        }
        return result.next;
    }
}
