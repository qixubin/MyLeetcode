package com.qxb.leetcode._82;

/**
 * Created by hacker on 7/14/2016.

 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.

 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(0);
        ListNode res = prev;
        prev.next = head;

        ListNode cur = head;
        int prevValue =-1;
        boolean dup = false;
        while(cur!=null){
            if (cur.next ==null || cur.next.val != cur.val){
                if(!dup){
                    prev.next = cur;
                    prev =cur;
                }else{
                    if (cur.next ==null){
                        prev.next =null;
                    }
                    dup =false;
                }

            }else{
                dup =true;

            }
            cur = cur.next;
        }

        return res.next;
    }

    public static void main(String[] argv){
        Solution so = new Solution();

//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(3);
//        ListNode n5 = new ListNode(4);
//        ListNode n6 = new ListNode(4);
//        ListNode n7 = new ListNode(5);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);

        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        ListNode node = so.deleteDuplicates(n1);
        System.out.println("end");
    }
}


