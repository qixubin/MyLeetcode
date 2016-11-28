package com.qxb.leetcode._86;

/**
 * Created by hacker on 7/22/2016.

 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 */
public class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode less = null;
        ListNode begin = null;
        ListNode more = null;
        ListNode nextbegin =null;

        while(head !=null){
            if (head.val <x){
                if (less ==null){
                    less = new ListNode(head.val);
                    begin = less;
                }else{
                    less.next = new ListNode(head.val);
                    less = less.next;
                }
            }else{
                if (more ==null){
                    more  = new ListNode(head.val);
                    nextbegin =more;
                }else{
                    more.next = new ListNode(head.val);
                    more = more.next;
                }
            }
            head = head.next;
        }

        if (begin ==null){
            return nextbegin;
        }else{
            less.next = nextbegin;
            return begin;
        }


    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Solution  so = new Solution();
        ListNode res = so.partition(n1, 3);
        System.out.println(res.val);

    }

}
