package com.qxb.leetcode._61;

import java.util.ArrayList;

/**
 * Created by hacker on 7/1/2016.

 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.


 */

//leetcode solution not use arraylist, use two pointer
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head ==null || head.next ==null|| k==0)
            return head;

        ArrayList<ListNode> li = new ArrayList<ListNode>();
        ListNode step = head;
        while(step!=null)
        {
            li.add(step);
            step = step.next;
        }
        int len = li.size();

        k = k%len;

        if (k == 0)
            return head;



        ListNode newHead = li.get(li.size() -k);
        li.get(li.size()-1).next = head;
        li.get(li.size()-k-1).next =null;

        return newHead;
    }

    public static void main(String[] argv){
        Solution so = new Solution();

        ListNode n_1 = new ListNode(1);
        ListNode n_2 = new ListNode(2);
        ListNode n_3 = new ListNode(3);
        ListNode n_4 = new ListNode(4);
        ListNode n_5 = new ListNode(5);

        n_1.next = n_2;
        n_2.next = n_3;
        n_3.next = n_4;
        n_4.next = n_5;


        ListNode res = so.rotateRight(n_1, 10);
        System.out.println(res.val);

//        System.out.println(3-3/2*2);
    }
}
