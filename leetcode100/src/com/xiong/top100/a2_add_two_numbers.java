package com.xiong.top100;

import java.util.ArrayList;

/**
 * @author xiong
 * @Description
 * @date 2023-02-06 5:34 下午
 */
public class a2_add_two_numbers {

    public static void main(String[] args) {


    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode resultNodeTmp = new ListNode();
        resultNodeTmp = resultNode;
        int isAddOne = 0;
        while (l1 !=null || l2 !=null || isAddOne==1){
            ListNode listNodeTmp = new ListNode();
            int l1Val = 0;
            int l2Val = 0;
            if(l1 != null){
                l1Val = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            int resultVal = l1Val + l2Val + isAddOne;
            if(resultVal>9){
                resultVal = resultVal-10;
                isAddOne = 1;
            }else{
                isAddOne = 0;
            }
            listNodeTmp.val = resultVal;
            resultNode.next = listNodeTmp;
            resultNode = listNodeTmp;
        }
        return  resultNodeTmp.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}




