package com.qxb.leetcode._23;

/**
 * Created by qixubin on 2016/5/9.
 */

class ss{

    public ss(ListNode s, int index){
        this.node =s ;
        this.index = index;
    }
    ListNode node;
    int index;
}
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //ListNode[] heads = new ListNode[lists.length];

        ListNode first = null;
        ListNode step = null;
        ss start = null;

        while( (start = getSmallest(lists)).node != null ){
            if (first == null){
                first = start.node;
                step = start.node;
            }else{
                step.next = start.node;
                step = step.next;
            }

            move(lists, start.index);
        }

        return first;
    }

    public ss getSmallest(ListNode[] heads) {
        ListNode cur = null;
        int curInt = -1;
        for (int i  = 0; i < heads.length; i++) {
            ListNode node = heads[i];
            if (node == null)
                continue;

            if (cur == null) {
                cur = new ListNode(node.val);
                curInt = i;

            } else if (cur.val > node.val) {
                cur.val = node.val;
                curInt = i;

            }
        }

        return new ss(cur, curInt);
    }

    public void move(ListNode[] heads, int index){
        ListNode node = heads[index];
        heads[index] = node.next;
    }

    public static void main(String[] argc) {
        Solution s1 = new Solution();
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

        ListNode[] lists= new ListNode[]{L11, L21, L31};
        s1.mergeKLists(lists);
    }
}
