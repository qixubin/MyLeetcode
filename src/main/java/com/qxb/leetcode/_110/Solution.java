package com.qxb.leetcode._110;

/**
 * Created by hacker on 7/29/2016.

 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root ==null) return true;
        Integer[] left = new Integer[1];
        left[0] =0;
        Integer[] right = new Integer[1];
        right[0] =0;

        helper(root.left, 1,left);
        helper(root.right, 1,right);
        return Math.abs(left[0] - right[0]) <2 && isBalanced(root.left) && isBalanced(root.right) ;
    }

    public void helper(TreeNode cur, int cur_level, Integer[] val){
        if (cur ==null) return;
        if (cur_level > val[0]) val[0] = cur_level;
        helper(cur.left, cur_level+1, val);
        helper(cur.right, cur_level+1, val);
    }

    public static void main(String[] args){
        Solution so = new Solution();
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        tn1.right = tn2;
        tn2.right = tn3;
        boolean res =so.isBalanced(tn1);
        System.out.println(res);
    }
}
