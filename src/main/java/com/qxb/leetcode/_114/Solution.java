package com.qxb.leetcode._114;

/**
 * Created by hacker on 7/30/2016.

 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

       1
     / \
    2   5
  / \   \
 3   4   6

 The flattened tree should look like:

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6

 click to show hints.
 Hints:

 If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root ==null) return;
        traverse(root, null);
    }

    private TreeNode traverse(TreeNode root, TreeNode previous) {

        if (previous !=null){
            previous.left = null;
            previous.right = root;}

        if (root == null)
            return previous;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left ==null){
            return traverse(right, root);
        }

        TreeNode tn = traverse(left, root);

        return traverse(right, tn);
    }
    public static void main(String[] args){

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);

        tn1.left = tn2;
        tn1.right = tn5;
        tn2.left = tn3;
        tn2.right = tn4;
        tn5.right = tn6;

        Solution  so = new Solution();
        so.flatten(tn1);
        System.out.println("done");

    }
}
