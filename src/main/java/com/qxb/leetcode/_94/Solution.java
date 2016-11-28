package com.qxb.leetcode._94;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 7/27/2016.
 *
 Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],

 1
   \
    2
   /
  3

 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?


 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {


        List<Integer> res = new ArrayList<Integer>();

        if (root ==null) return res;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
        return res;
    }

    public void helper(TreeNode node, List<Integer> res){
        if (node == null) return;

        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }

    public static void main(String[] args){
        Solution so  = new Solution();
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);

        tn1.right = tn2;
        tn2.left = tn3;

        List<Integer> li = so.inorderTraversal(tn1);

        for(int lii: li){
            System.out.println(lii);
        }



    }

}
