package com.xiong.jingdian150_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiong
 * @create 2025-11-19-14:21
 */
public class c4_23mergeKLists {
    public static void main(String[] args) {
        c4_23mergeKLists c423mergeKLists = new c4_23mergeKLists();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);

        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(9);

        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;

        listNode11.next = listNode12;
        listNode12.next = listNode13;
        ListNode listNode = c423mergeKLists.mergeKLists(new ListNode[]{listNode1,listNode11,listNode4});
        System.out.println(listNode);
    }



    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0){
            return null;
        }
        ArrayList<ListNode> tmpListNode = new ArrayList<>();
        List<ListNode> list = Arrays.stream(lists).toList();
        while (list.size()>1){
            for (int i=0;i<list.size();i+=2){
                ListNode listNode;
                if (i+1<list.size()){
                    listNode = mergeTwoLists(list.get(i), list.get(i + 1));
                }else {
                    listNode =list.get(i);
                }
                tmpListNode.add(listNode);
            }
            list = tmpListNode;
            tmpListNode = new ArrayList<>();
        }
        return list.get(0);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultNode = new ListNode();
        ListNode curlist = resultNode;
        while (list1!=null && list2!=null){
            if(list1.val<=list2.val){
                curlist.next = list1;
                list1 = list1.next;
            }else {
                curlist.next = list2;
                list2 = list2.next;
            }
            curlist = curlist.next;
        }
        if (list1!=null){
            curlist.next = list1;
        }
        if (list2!=null){
            curlist.next = list2;
        }
        return resultNode.next;
    }
}
