package com.qxb.leetcode._83;

/**
 * Created by hacker on 7/14/2016.
 *
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.

 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next ==null) return head;

        ListNode cur = head;

        int prev =-1;
        ListNode prevNode = null;

        while(cur!=null){
            if (prevNode ==null){
                prevNode = cur;
                prev = cur.val;
            }else{
                if(cur.val ==prev){

                }else{
                    prevNode.next = cur;
                    prevNode = cur;
                    prev = cur.val;
                }
            }
            cur = cur.next;
        }
        prevNode.next =null;

        return head;
    }

    public static void main(String[] argv){
        Solution so = new Solution();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode node = so.deleteDuplicates(n1);
        System.out.println("111");
    }
}
