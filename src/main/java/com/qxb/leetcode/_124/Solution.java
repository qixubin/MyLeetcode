package com.qxb.leetcode._124;

/**
 * Created by hacker on 8/9/2016.

 Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

 For example:
 Given the below binary tree,

    1
  / \
 2   3

 Return 6.

 */
public class Solution {
    public int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        helper(root);
        return maxValue;
    }

    public int helper(TreeNode root) {
        if (root ==null) return 0;

        int leftMax = helper(root.left);
        int rightMax = helper(root.right);
        int sum = Math.max(leftMax,0) + Math.max(rightMax,0) + root.val;

        if (sum > maxValue)
            maxValue = sum;


        return Math.max(0,Math.max(leftMax, rightMax)) + root.val;
    }

    public static void main(String[] args){

        TreeNode tn1 = new TreeNode(-3);
        Solution so = new Solution();
        int res = so.maxPathSum(tn1);
        System.out.println(res);
    }

}
