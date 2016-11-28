package com.qxb.leetcode._108;

import java.util.Arrays;

/**
 * Created by hacker on 7/29/2016.

 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        int len = nums.length;
        if (len ==0) return null;
        if (len ==1) return new TreeNode(nums[0]);
        int half =len/2;
        TreeNode root = new TreeNode(nums[half]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, half));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, half+1,len ));

        return root;
    }


    public static void main(String[] args){
        Solution so = new Solution();
//        int[] nums = {1,3};
        int[] nums = {3,5,8};
        TreeNode tn =so.sortedArrayToBST(nums);
        System.out.println(tn.val);
    }

}
