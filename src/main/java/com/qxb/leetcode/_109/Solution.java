package com.qxb.leetcode._109;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hacker on 7/29/2016.

 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> ali = new ArrayList<Integer>();
        while(head != null){
            ali.add(head.val);
            head = head.next;
        }

        Integer[] nums =  ali.toArray(new Integer[ali.size()]);

        return sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(Integer[] nums) {

        int len = nums.length;
        if (len ==0) return null;
        if (len ==1) return new TreeNode(nums[0]);
        int half =len/2;
        TreeNode root = new TreeNode(nums[half]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, half));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, half+1,len ));

        return root;
    }


}
