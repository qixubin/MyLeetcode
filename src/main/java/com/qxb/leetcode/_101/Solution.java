package com.qxb.leetcode._101;

/**
 * Created by hacker on 7/29/2016.

 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

     1
    / \
   2   2
  / \ / \
 3  4 4  3

 But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
  \   \
   3    3

 Note:
 Bonus points if you could solve it both recursively and iteratively.

 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {

        if (root ==null) return true;

        StringBuffer leftSB = new StringBuffer();
        StringBuffer rightSB = new StringBuffer();
        traverse(root.left, leftSB,1);
        Rtraverse(root.right, rightSB,1);

        System.out.println(leftSB);
        System.out.println(rightSB);
        return leftSB.toString().equals(rightSB.toString());
    }

    private void traverse(TreeNode root, StringBuffer sb, int level) {

        if (root == null) {
            sb.append("X");
            return;
        }
        traverse(root.left, sb, level+1);

        sb.append(root.val+""+level);

        traverse(root.right,sb, level+1);
    }

    private void Rtraverse(TreeNode root, StringBuffer sb, int level) {

        if (root == null) {
            sb.append("X");
            return;
        }
        Rtraverse(root.right, sb, level+1);

        sb.append(root.val+""+level);

        Rtraverse(root.left,sb, level+1);
    }

    public static void main(String[] args){
//        TreeNode tn1 = new TreeNode(1);
//        TreeNode tn2 = new TreeNode(2);
//        TreeNode tn3 = new TreeNode(2);
//        TreeNode tn4 = new TreeNode(3);
//        TreeNode tn5 = new TreeNode(4);
//        TreeNode tn6 = new TreeNode(4);
//        TreeNode tn7 = new TreeNode(3);

//        tn1.left = tn2;
//        tn1.right = tn3;
//        tn2.left =tn4;
//        tn2.right =tn5;
//
//        tn3.left = tn6;
//        tn3.right = tn7;

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(3);
        TreeNode tn5 = new TreeNode(2);

        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn3.left = tn5;

        Solution so = new Solution();
        so.isSymmetric(tn1);
    }
}
