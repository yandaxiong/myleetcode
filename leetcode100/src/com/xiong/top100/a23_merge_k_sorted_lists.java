package com.xiong.top100;

/**
 * @author xiong
 * @Description 合并K个升序链表
 * @date 2023-02-27 8:32 下午
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class a23_merge_k_sorted_lists {
    public static void main(String[] args) {

    }
    public static  ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }
    public static  ListNode merge(ListNode[] lists,int l,int r) {
        if(l == r){
            return  lists[l];
        }
        if(l>r){
            return null;
        }
        int mid = (l+r) >> 1;
        return  mergeTwoLists(merge(lists, l,mid),merge(lists,mid+1,r));
    }


    public static  ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode resultNode = null;
        for (ListNode list : lists) {
            resultNode = mergeTwoLists(resultNode, list);
        }
        return  resultNode;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a == null){
            return  b;
        }
        if(b==null){
            return a;
        }
        ListNode head = new ListNode();
        ListNode presentNode = head;
        while (a!=null && b!=null){
            if(a.val<b.val){
                presentNode.next = a;
                a = a.next;
            }else {
                presentNode.next = b;
                b = b.next;
            }
            presentNode = presentNode.next;
        }
        presentNode.next = a==null?b:a;
        return head.next;
    }
}
