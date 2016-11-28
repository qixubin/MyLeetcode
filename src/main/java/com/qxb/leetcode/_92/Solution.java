package com.qxb.leetcode._92;

/**
 * Created by hacker on 7/26/2016.

 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.

 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n ==m) return head;

        ListNode index = null;
        ListNode prev= new ListNode(0);
        prev.next = head;
        int k =m;
        while(k >1){

            prev  = prev.next;
            k--;
        }
        index = prev.next;

        ListNode curStep = index;
        ListNode curNextStep = index.next;

        ListNode last = null;
        ListNode nextNext = null;
        while (m < n) {
            if (m == n-1){
                last = curNextStep.next;
                prev.next = curNextStep;
                curNextStep.next = curStep;
                index.next = last;
            }else{
                nextNext = curNextStep.next;
                curNextStep.next =curStep;
                curStep = curNextStep;
                curNextStep =nextNext;
            }


            n--;
        }

        if (m ==1) return prev.next;
        return head;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution so = new Solution();

//        ListNode res  = so.reverseBetween(n1,2,4);
//        System.out.println(res);

        ListNode res = so.reverseBetween(n4,1,2);
        System.out.println(res);
    }


}
