package com.qxb.leetcode._23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qixubin on 2016/5/9.
 */
public class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeHelper(ListNode[] lists, int start, int end) {


        if (start == end) {
            return lists[start];
        }

        int mid = start + ( end -start ) / 2;


        ListNode right = mergeHelper(lists, start, mid);
        ListNode left = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);

    }


    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tail = new ListNode(0);
        ListNode step = tail;

        while(( list1 !=null) && (list2 !=null)){
            if (list1.val < list2.val){
                step.next = list1;

                list1 = list1.next;
            }else{
                step.next = list2;

                list2 = list2.next;
            }
            step = step.next;

        }

        if (list1!=null){
            step.next = list1;
        }

        if (list2!=null){
            step.next = list2;
        }

        return tail.next;
    }


//    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
//        if (start == end) {
//            return lists.get(start);
//        }
//
//        int mid = start + (end - start) / 2;
//        ListNode left = mergeHelper(lists, start, mid);
//        ListNode right = mergeHelper(lists, mid + 1, end);
//        return mergeTwoLists(left, right);
//    }

//    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                tail.next = list1;
//                tail = list1;
//                list1 = list1.next;
//            } else {
//                tail.next = list2;
//                tail = list2;
//                list2 = list2.next;
//            }
//        }
//        if (list1 != null) {
//            tail.next = list1;
//        } else {
//            tail.next = list2;
//        }
//
//        return dummy.next;
//    }

    public static void main(String[] argc) {
        Solution1 s1 = new Solution1();
        ListNode L11 = new ListNode(1);
        ListNode L12 = new ListNode(4);
        ListNode L13 = new ListNode(6);
        ListNode L14 = new ListNode(7);
        L11.next = L12;
        L12.next = L13;
        L13.next = L14;

        ListNode L21 = new ListNode(2);
        ListNode L22 = new ListNode(5);
        ListNode L23 = new ListNode(9);
        L21.next = L22;
        L22.next = L23;


        ListNode L31 = new ListNode(1);
        ListNode L32 = new ListNode(3);
        ListNode L33 = new ListNode(4);
        ListNode L34 = new ListNode(5);
        ListNode L35 = new ListNode(7);
        ListNode L36 = new ListNode(8);
        ListNode L37 = new ListNode(9);
        L31.next = L32;
        L32.next = L33;
        L33.next = L34;
        L34.next = L35;
        L35.next = L36;
        L36.next = L37;

        ListNode[] lists = new ListNode[]{L11, L21, L31};
        s1.mergeKLists(lists);
    }
}

