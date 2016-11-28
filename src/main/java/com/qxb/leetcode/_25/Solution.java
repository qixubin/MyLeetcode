package com.qxb.leetcode._25;

/**
 * Created by qixubin on 2016/5/10.
 *
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 Subscribe to see which companies asked this question
 *
 *
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;
        while (head.next != null) {
            head = reverseNextK(head, k);
        }

        return dummy.next;
    }

    // reverse head->n1->..->nk->next..
    // to head->nk->..->n1->next..
    // return n1
    private ListNode reverseNextK(ListNode head, int k) {
        // check there is enought nodes to reverse
        ListNode next = head; // next is not null
        for (int i = 0; i < k; i++) {
            if (next.next == null) {
                return next;
            }
            next = next.next;
        }

        // reverse
        ListNode n1 = head.next;
        ListNode prev = head, curt = n1;
        for (int i = 0; i < k; i++) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }

        n1.next = curt;
        head.next = prev;
        return n1;
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
        ListNode L8 = new ListNode(8);
        ListNode L9 = new ListNode(9);

        L1.next = L2;
        L2.next = L3;
        L3.next = L4;
        L4.next = L5;
        L5.next = L6;
        L6.next = L7;
        L7.next = L8;
        L8.next = L9;

        ListNode newHead = L1;

        newHead =  s1.reverseKGroup(L1,4);

        while (newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
