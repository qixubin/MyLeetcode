package com.qxb.leetcode._203;

/**
 * Created by qixubin on 2016/5/16.
 *  Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode previous = dummy;

        while(head !=null){

            if (head.val == val){
                previous.next = head.next;
            }else{
                previous = head;
            }

            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] argc){
        Solution s1 = new Solution();

//        ListNode L1 = new ListNode(1);
//        ListNode L2 = new ListNode(2);
//        ListNode L3 = new ListNode(6);
//        ListNode L4 = new ListNode(3);
//        ListNode L5 = new ListNode(4);
//        ListNode L6 = new ListNode(5);
//        ListNode L7 = new ListNode(6);
//
//        L1.next = L2;
//        L2.next = L3;
//        L3.next = L4;
//        L4.next = L5;
//        L5.next = L6;
//        L6.next = L7;
//
//        s1.removeElements(L1, 6);

        ListNode L1 = new ListNode(1);
        ListNode L2 = new ListNode(1);
        L1.next = L2;
        s1.removeElements(L1,1);
    }
}
