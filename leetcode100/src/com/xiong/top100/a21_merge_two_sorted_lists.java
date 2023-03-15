package com.xiong.top100;

/**
 * @author xiong
 * @Description  合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @date 2023-02-27 3:53 下午
 */
public class a21_merge_two_sorted_lists {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode presentNode = head;
        for (int i=2;i<=5;i++){
            ListNode listNode = new ListNode(i);
            presentNode.next = listNode;
            presentNode = listNode;
        }
        ListNode head2 = new ListNode(7);
        ListNode listNode = mergeTwoLists(head,head2);
        System.out.println(listNode);
    }
    public static  ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode presentNode = new ListNode();
        ListNode resultNode = presentNode;
        while (list1!=null || list2!=null){
            if(list1==null){
                presentNode.next = list2;
                presentNode = presentNode.next;
                list2 = list2.next;
            }else if(list2==null){
                presentNode.next = list1;
                presentNode = presentNode.next;
                list1 = list1.next;
            }else {
                if(list1.val> list2.val){
                    presentNode.next = list2;
                    presentNode = presentNode.next;
                    list2 = list2.next;
                }else {
                    presentNode.next = list1;
                    presentNode = presentNode.next;
                    list1 = list1.next;
                }
            }
        }
        return resultNode.next;
    }

}
