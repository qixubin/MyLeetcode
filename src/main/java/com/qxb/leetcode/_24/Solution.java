package com.qxb.leetcode._24;

/**
 * Created by qixubin on 2016/5/9.
 *
 *
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


 *
 *
 *
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode step = new ListNode(0);
        step.next = head;

        ListNode result =step;

        while((head.next!=null) &&(head.next.next !=null)){
            step.next = head.next;
            ListNode nh = step.next.next;

            step.next.next = head;
            head = nh;
            step.next.next.next = nh;


            step = step.next.next;
        }

        if (head.next !=null){
            ListNode nh = head.next;
            nh.next = head;
            head.next = null;
            step.next = nh;
        }


        return result.next;
    }
    public static void main(String[] argc){
        Solution s1 = new Solution();
        ListNode L1 = new ListNode(1);
        ListNode L2 = new ListNode(2);
        ListNode L3 = new ListNode(3);
        ListNode L4 = new ListNode(4);
        ListNode L5 = new ListNode(5);
        ListNode L6 = new ListNode(6);
        ListNode L7 = new ListNode(7);

        L1.next = L2;
        L2.next = L3;
        L3.next = L4;
        L4.next = L5;
        L5.next = L6;
        L6.next = L7;

        ListNode newHead = L1;
//        while (newHead!=null){
//            System.out.println(newHead.val);
//            newHead = newHead.next;
//        }

        newHead =  s1.swapPairs(L1);

        while (newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
