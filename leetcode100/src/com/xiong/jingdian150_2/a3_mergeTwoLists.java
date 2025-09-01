package com.xiong.jingdian150_2;

/**
 * @author xiong
 * @create 2025-08-15-16:35
 */
public class a3_mergeTwoLists {
    public static void main(String[] args) {

    }
    public  ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        while (list1!=null || list2!=null){
            if(list1 == null){
                listNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }else if (list2 == null){
                listNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }else if (list1.val>=list2.val){
                listNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }else {
                listNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            listNode = listNode.next;
        }
        return head.next;
    }
}
